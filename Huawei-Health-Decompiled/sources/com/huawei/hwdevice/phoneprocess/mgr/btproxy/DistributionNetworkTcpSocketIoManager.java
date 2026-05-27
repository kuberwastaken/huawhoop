package com.huawei.hwdevice.phoneprocess.mgr.btproxy;

import android.os.SystemClock;
import androidx.media3.datasource.cache.CacheDataSink;
import health.compact.a.util.LogUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class DistributionNetworkTcpSocketIoManager {
    private boolean b;
    private final Delegator c;
    private volatile boolean d;
    private Selector f;
    private ServerSocketChannel j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f6544a = ByteBuffer.allocate(CacheDataSink.DEFAULT_BUFFER_SIZE);
    private final Set<SocketChannel> h = new HashSet(16);
    private final Set<SocketChannel> e = new HashSet(16);
    private final Set<SocketChannel> i = new HashSet(16);

    public interface Delegator {
        void doAccept(SocketChannel socketChannel);

        void doClose(SocketChannel socketChannel);

        void doRead(SocketChannel socketChannel, ByteBuffer byteBuffer);

        int doWrite(SocketChannel socketChannel);
    }

    public DistributionNetworkTcpSocketIoManager(Delegator delegator) {
        this.c = delegator;
    }

    public void d(SocketChannel socketChannel) {
        synchronized (this.h) {
            this.h.add(socketChannel);
        }
        Selector selector = this.f;
        if (selector != null) {
            selector.wakeup();
        }
    }

    public void b(SocketChannel socketChannel) {
        synchronized (this.e) {
            this.e.add(socketChannel);
        }
        Selector selector = this.f;
        if (selector != null) {
            selector.wakeup();
        }
    }

    public void a(SocketChannel socketChannel) {
        synchronized (this.i) {
            this.i.add(socketChannel);
        }
        Selector selector = this.f;
        if (selector != null) {
            selector.wakeup();
        }
    }

    public void d() {
        LogUtil.a("DistributionNetworkTcpSocketIoManager", "Shutdown requested");
        this.d = false;
        Selector selector = this.f;
        if (selector != null) {
            selector.wakeup();
        }
    }

    public void a() throws IOException {
        this.d = true;
        this.f = SelectorProvider.provider().openSelector();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 0);
        ServerSocketChannel serverSocketChannelOpen = ServerSocketChannel.open();
        this.j = serverSocketChannelOpen;
        serverSocketChannelOpen.configureBlocking(false);
        this.j.socket().bind(inetSocketAddress);
        this.j.register(this.f, 16);
        LogUtil.a("DistributionNetworkTcpSocketIoManager", "Listening for TCP sockets at ", this.j.socket());
    }

    public void e() throws IOException {
        ServerSocketChannel serverSocketChannel = this.j;
        if (serverSocketChannel != null) {
            try {
                serverSocketChannel.close();
            } catch (IOException unused) {
                LogUtil.d("IOException", new Object[0]);
            }
            this.j = null;
        }
        this.f.close();
    }

    public void b() throws ClosedSelectorException, IOException {
        LogUtil.a("DistributionNetworkTcpSocketIoManager", "Tcp relaying thread started, entering into select loop");
        while (this.d) {
            LogUtil.a("DistributionNetworkTcpSocketIoManager", "enter running tcp loop");
            this.b = false;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f.select();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            Iterator<SelectionKey> it = this.f.selectedKeys().iterator();
            synchronized (this.f.selectedKeys()) {
                a(it);
            }
            if (h()) {
                this.b = true;
            }
            if (i()) {
                this.b = true;
            }
            if (c()) {
                this.b = true;
            }
            if (this.b) {
                LogUtil.a("DistributionNetworkTcpSocketIoManager", "Select completed in ", Long.valueOf(jElapsedRealtime2), " ms");
            } else {
                LogUtil.a("DistributionNetworkTcpSocketIoManager", "Select completed in ", Long.valueOf(jElapsedRealtime2), " ms and ", "resulted in no work performed ", Integer.valueOf(this.f.keys().size()));
            }
        }
        d(this.j);
        LogUtil.a("DistributionNetworkTcpSocketIoManager", "Loop exited");
    }

    private void a(Iterator<SelectionKey> it) {
        while (it.hasNext()) {
            SelectionKey next = it.next();
            if (!next.isValid()) {
                LogUtil.c("DistributionNetworkTcpSocketIoManager", "key is Invalid");
                it.remove();
            } else {
                try {
                    if (next.isConnectable()) {
                        a(next);
                        it.remove();
                        this.b = true;
                    } else if (next.isAcceptable()) {
                        e(next);
                        it.remove();
                        this.b = true;
                    } else {
                        a(it, next);
                    }
                } catch (IOException unused) {
                    LogUtil.d("DistributionNetworkTcpSocketIoManager", "Error during operating socket channels");
                    b(next);
                }
            }
        }
    }

    private void a(Iterator<SelectionKey> it, SelectionKey selectionKey) throws IOException {
        if (selectionKey.isReadable()) {
            if (d(selectionKey) == 0) {
                it.remove();
            }
            this.b = true;
        } else {
            if (selectionKey.isWritable()) {
                if (c(selectionKey) == 0) {
                    it.remove();
                }
                this.b = true;
                return;
            }
            it.remove();
        }
    }

    private boolean c() {
        ArrayList arrayList = new ArrayList(16);
        synchronized (this.h) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e((SocketChannel) it.next());
        }
        return !arrayList.isEmpty();
    }

    private boolean h() throws IOException {
        ArrayList arrayList = new ArrayList(16);
        synchronized (this.e) {
            arrayList.addAll(this.e);
            this.e.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SocketChannel) it.next()).register(this.f, 8);
        }
        if (!arrayList.isEmpty()) {
            LogUtil.a("DistributionNetworkTcpSocketIoManager", "Registered ", Integer.valueOf(arrayList.size()), " connecting channels");
        }
        return !arrayList.isEmpty();
    }

    private boolean i() throws IOException {
        ArrayList arrayList = new ArrayList(16);
        synchronized (this.i) {
            arrayList.addAll(this.i);
            this.i.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SelectionKey selectionKeyKeyFor = ((SocketChannel) it.next()).keyFor(this.f);
            if (selectionKeyKeyFor != null && selectionKeyKeyFor.isValid()) {
                selectionKeyKeyFor.interestOps(selectionKeyKeyFor.interestOps() | 4);
            }
        }
        if (!arrayList.isEmpty()) {
            LogUtil.a("DistributionNetworkTcpSocketIoManager", "Registered ", Integer.valueOf(arrayList.size()), " writing channels");
        }
        return !arrayList.isEmpty();
    }

    private void d(SelectableChannel selectableChannel) {
        for (SelectionKey selectionKey : this.f.keys()) {
            if (selectionKey.channel() != selectableChannel && selectionKey.channel().isOpen()) {
                b(selectionKey);
            }
        }
    }

    private void a(SelectionKey selectionKey) throws IOException {
        if (!((SocketChannel) selectionKey.channel()).finishConnect()) {
            b(selectionKey);
        } else {
            selectionKey.interestOps((selectionKey.interestOps() & (-9)) | 1);
            LogUtil.a("DistributionNetworkTcpSocketIoManager", "Channel connected");
        }
    }

    private void e(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannelAccept = ((ServerSocketChannel) selectionKey.channel()).accept();
        socketChannelAccept.configureBlocking(false);
        socketChannelAccept.socket().setTcpNoDelay(true);
        socketChannelAccept.register(this.f, 1);
        this.c.doAccept(socketChannelAccept);
        LogUtil.a("DistributionNetworkTcpSocketIoManager", "Accepted connection");
    }

    private int d(SelectionKey selectionKey) throws IOException {
        if (!(selectionKey.channel() instanceof SocketChannel)) {
            return -1;
        }
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        this.f6544a.clear();
        int i = socketChannel.read(this.f6544a);
        if (i == -1) {
            LogUtil.a("DistributionNetworkTcpSocketIoManager", "Channel has reached end-of-stream, closing");
            b(selectionKey);
            return i;
        }
        this.f6544a.flip();
        this.c.doRead(socketChannel, this.f6544a);
        LogUtil.a("DistributionNetworkTcpSocketIoManager", "Read ", Integer.valueOf(i), " bytes");
        return i;
    }

    private int c(SelectionKey selectionKey) {
        LogUtil.a("DistributionNetworkTcpSocketIoManager", "enterDoWrite");
        if (!(selectionKey.channel() instanceof SocketChannel)) {
            return -1;
        }
        int iDoWrite = this.c.doWrite((SocketChannel) selectionKey.channel());
        if (iDoWrite == 0) {
            selectionKey.interestOps(selectionKey.interestOps() & (-5));
        }
        if (iDoWrite != 0) {
            LogUtil.a("DistributionNetworkTcpSocketIoManager", "Wrote ", Integer.valueOf(iDoWrite), " bytes");
        } else {
            LogUtil.c("DistributionNetworkTcpSocketIoManager", "No bytes written: losing interest in channel write ability");
        }
        return iDoWrite;
    }

    private void e(SocketChannel socketChannel) {
        try {
            this.c.doClose(socketChannel);
            socketChannel.close();
            LogUtil.a("DistributionNetworkTcpSocketIoManager", "Closed channel");
        } catch (IOException unused) {
            LogUtil.d("DistributionNetworkTcpSocketIoManager", "Failed to close channel ");
        }
    }

    private void b(SelectionKey selectionKey) {
        selectionKey.cancel();
        SelectableChannel selectableChannelChannel = selectionKey.channel();
        if (selectableChannelChannel instanceof SocketChannel) {
            e((SocketChannel) selectableChannelChannel);
            return;
        }
        try {
            LogUtil.a("DistributionNetworkTcpSocketIoManager", "channel close");
            selectableChannelChannel.close();
        } catch (IOException unused) {
            LogUtil.d("DistributionNetworkTcpSocketIoManager", "Failed to close non-socket channel");
        }
    }
}

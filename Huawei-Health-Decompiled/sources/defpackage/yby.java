package defpackage;

import java.util.ArrayList;
import java.util.List;
import org.ahocorasick.trie.handler.EmitHandler;

/* JADX INFO: loaded from: classes8.dex */
public class yby implements EmitHandler {
    private List<ybq> d = new ArrayList();

    @Override // org.ahocorasick.trie.handler.EmitHandler
    public void emit(ybq ybqVar) {
        this.d.add(ybqVar);
    }

    public List<ybq> d() {
        return this.d;
    }
}

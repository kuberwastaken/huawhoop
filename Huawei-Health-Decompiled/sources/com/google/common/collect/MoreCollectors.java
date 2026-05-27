package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MoreCollectors$;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes2.dex */
@ElementTypesAreNonnullByDefault
final class MoreCollectors {
    private static final Collector<Object, ?, Optional<Object>> TO_OPTIONAL = Collector.of(new MoreCollectors$.ExternalSyntheticLambda0(), new MoreCollectors$.ExternalSyntheticLambda1(), new MoreCollectors$.ExternalSyntheticLambda2(), new MoreCollectors$.ExternalSyntheticLambda3(), Collector.Characteristics.UNORDERED);
    private static final Object NULL_PLACEHOLDER = new Object();
    private static final Collector<Object, ?, Object> ONLY_ELEMENT = Collector.of(new MoreCollectors$.ExternalSyntheticLambda0(), new MoreCollectors$.ExternalSyntheticLambda4(), new MoreCollectors$.ExternalSyntheticLambda2(), new MoreCollectors$.ExternalSyntheticLambda5(), Collector.Characteristics.UNORDERED);

    public static <T> Collector<T, ?, Optional<T>> toOptional() {
        return (Collector<T, ?, Optional<T>>) TO_OPTIONAL;
    }

    static /* synthetic */ void lambda$static$0(ToOptionalState toOptionalState, Object obj) {
        if (obj == null) {
            obj = NULL_PLACEHOLDER;
        }
        toOptionalState.add(obj);
    }

    static /* synthetic */ Object lambda$static$1(ToOptionalState toOptionalState) {
        Object element = toOptionalState.getElement();
        if (element == NULL_PLACEHOLDER) {
            return null;
        }
        return element;
    }

    public static <T> Collector<T, ?, T> onlyElement() {
        return (Collector<T, ?, T>) ONLY_ELEMENT;
    }

    private static final class ToOptionalState {
        static final int MAX_EXTRAS = 4;

        @CheckForNull
        Object element = null;
        List<Object> extras = Collections.emptyList();

        ToOptionalState() {
        }

        IllegalArgumentException multiples(boolean z) {
            StringBuilder sb = new StringBuilder("expected one element but was: <");
            sb.append(this.element);
            for (Object obj : this.extras) {
                sb.append(", ");
                sb.append(obj);
            }
            if (z) {
                sb.append(", ...");
            }
            sb.append('>');
            throw new IllegalArgumentException(sb.toString());
        }

        void add(Object obj) {
            Preconditions.checkNotNull(obj);
            if (this.element == null) {
                this.element = obj;
                return;
            }
            if (this.extras.isEmpty()) {
                ArrayList arrayList = new ArrayList(4);
                this.extras = arrayList;
                arrayList.add(obj);
            } else {
                if (this.extras.size() < 4) {
                    this.extras.add(obj);
                    return;
                }
                throw multiples(true);
            }
        }

        ToOptionalState combine(ToOptionalState toOptionalState) {
            if (this.element == null) {
                return toOptionalState;
            }
            if (toOptionalState.element == null) {
                return this;
            }
            if (this.extras.isEmpty()) {
                this.extras = new ArrayList();
            }
            this.extras.add(toOptionalState.element);
            this.extras.addAll(toOptionalState.extras);
            if (this.extras.size() <= 4) {
                return this;
            }
            List<Object> list = this.extras;
            list.subList(4, list.size()).clear();
            throw multiples(true);
        }

        Optional<Object> getOptional() {
            if (this.extras.isEmpty()) {
                return Optional.ofNullable(this.element);
            }
            throw multiples(false);
        }

        Object getElement() {
            if (this.element == null) {
                throw new NoSuchElementException();
            }
            if (this.extras.isEmpty()) {
                return this.element;
            }
            throw multiples(false);
        }
    }

    private MoreCollectors() {
    }
}

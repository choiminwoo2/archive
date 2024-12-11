package com.example.springstart.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader){
        this.classLoader =classLoader;
    }
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> autoConfigs = new ArrayList<>();
        // 강의와 다르게 내부 클래스 load가 반환 하는것은 ImportCandidates를 인스턴스 한 것. iterator()메서드를 따로 만들어둠.
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).iterator().forEachRemaining(autoConfigs::add);

        /*
        *
        *   public <T> T[] toArray(T[] a) {
            int size = size();
            if (a.length < size)
                return Arrays.copyOf(this.a, size,
                                     (Class<? extends T[]>) a.getClass());
            System.arraycopy(this.a, 0, a, 0, size);
            if (a.length > size)
                a[size] = null;
            return a;
            }
        *
        * */
        return autoConfigs.toArray(new String[0]);

    }
}

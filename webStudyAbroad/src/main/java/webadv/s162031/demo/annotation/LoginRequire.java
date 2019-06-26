package webadv.s162031.demo.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoginRequire {
 //   boolean required() default true;
    boolean check() default false;
}

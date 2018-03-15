import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    private static Tablet tablet;
    private static Class tabletClass;
    static {
        tablet = new Tablet("iPad 4", 1.4E9, 2, 1E9,
                1.6E10, OperationSystemNames.iOS, 9.7, 11560);
        tabletClass = tablet.getClass();
    }
    public static void main(String[] args) throws Exception {

        InvokeMethodWithAnnotation(Tag.class);

        PrintAllFieldsWithAnnotations();

        System.out.println();

        PrintAllInterfaces();

        System.out.println();

        System.out.println(tablet);

    }

    private static void PrintAllInterfaces() {
        Class[] interfaces = tabletClass.getInterfaces();
        for (Class s : interfaces) {
            System.out.println(s);
        }
    }

    private static void PrintAllFieldsWithAnnotations() {
        Field[] fields = tabletClass.getDeclaredFields();
        for (Field s : fields) {
            System.out.println(s +" " + Arrays.toString(s.getAnnotations()));
        }
    }

    private static void InvokeMethodWithAnnotation(Class<? extends Annotation> Annotation) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = tabletClass.getMethods();
        for (Method s : methods) {
            if(s.isAnnotationPresent(Annotation)) {
                s.invoke(tablet, OperationSystemNames.ANDROID);
                System.out.println(tablet.getOsName());
            }
        }
    }
}

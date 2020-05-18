package com.javalesson.lambdas;

public class TransformUtils<T> {

	public static void main(String[] args) {
		Double d = 0.123d;
		String s = "Hello";
		String suffix = "Alex";

		TransformUtils<Double> doubleTransformUtils = new TransformUtils<>();
		TransformUtils<String> stringTransformUtils = new TransformUtils<>();

        System.out.println(doubleTransformUtils.transform(d, Math::sin)); // 0.12269009002431533
        System.out.println(stringTransformUtils.transform(s, TransformUtils::exclaim)); // HELLO!!!!
        System.out.println(stringTransformUtils.transform(s, x -> s.concat(suffix)));  // HelloAlex
        System.out.println(stringTransformUtils.transform(suffix, s::concat));   // HelloAlex
        System.out.println(stringTransformUtils.transform(s, y -> y.toUpperCase()));
        // toUpperCase не принимает аргументов но работает
        System.out.println(stringTransformUtils.transform(s, String::toUpperCase));
        System.out.println(stringTransformUtils.transform(s, String::new)); // передача в конструктор String
    }

    T transform(T t, Transformable<T> function){
    	return function.transform(t);
    }

    static String exclaim(String s){
    	return s.toUpperCase()+"!!!!";
    }
}

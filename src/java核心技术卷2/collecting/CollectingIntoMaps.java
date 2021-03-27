package com.collecting;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by weiliangchun on 2019/12/5
 */
public class CollectingIntoMaps {
    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"), new Person(1002, "Bob"), new Person(1003, "Mary"));
    }

    public static void main(String[] args) {
        Map<Integer, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);

        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson: " + idToPerson.getClass().getName());

        idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity(), (existingValue, newValue) -> {
            throw new IllegalStateException();
        }, TreeMap::new));
        System.out.println("idToPerson: " + idToPerson.getClass().getName());

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
                Collectors.toMap(Locale::getDisplayLanguage, l -> l.getDisplayLanguage(l), (existingValue, newValue) -> existingValue)
        );
        System.out.println("languageNames: " + languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(Locale::getCountry, l -> Collections.singleton(l.getDisplayLanguage()), (a, b) -> {
                    Set<String> union = new HashSet<>(a);
                    union.addAll(b);
                    return union;
                })
        );
        System.out.println("countryLanguageSets: " + countryLanguageSets);
    }
}

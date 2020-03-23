package exercice;

import list.exercice.hierarchy.vivant.domaine.regne.Animal;
import list.exercice.hierarchy.vivant.domaine.regne.embranchements.Vertebrate;
import list.exercice.hierarchy.vivant.domaine.regne.embranchements.classe.Mammal;
import list.exercice.hierarchy.vivant.domaine.regne.embranchements.classe.ordre.Felidae;
import list.exercice.hierarchy.vivant.domaine.regne.embranchements.classe.ordre.espece.Cat;
import list.exercice.hierarchy.vivant.domaine.regne.embranchements.classe.ordre.espece.Horse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreservingLiskov {

    private static final List<Cat> cats = new ArrayList<>(someList());
    private static final List<Felidae> felidaes = new ArrayList<>(someList());
    private static final List<Mammal> mammals = new ArrayList<>(someList());
    private static final List<Vertebrate> vertebrates = new ArrayList<>(someList());
    private static final List<Animal> animals = new ArrayList<>(someList());

    //    You decided that :
//
//          "if S is a subtype of T, List<S> is a subtype of List<T>
//
//    It follows the intuition that a List<Cat> is a List<Animal>
//    It means that the generic container List<> preserves the original inheritance order.
//
//    Until further notice, we will consider that this hypothesis is true.
//    Let's call it : ListPreservingInheritance.
//
//    For our hierarchy of the living, it means that the hierarchy tree generated by List<>
//    preserves the original order and therefore looks like :
//
//                             Animal                 List<Animal>
//                                ↑                        ↑
//                            Vertebrate            List<Vertebrate>
//                                ↑                        ↑
//    List<> applied to         Mammal        =       List<Mammal>
//                                ↑                        ↑
//                             Felidae                List<Felidae>
//                                ↑                        ↑
//                               Cat                    List<Cat>
//
//    For example, considering that List<Cat> s a subtype of List<Mammal>,
//    liskov principle is saying that :
//
//    - any method that accept a List<Mammal> should also accept and work flawlessly with a List<Cat> without
//    knowing it is manipulating a List<Cat>
//
//    - any property true for type List<Mammal> should also be true for List<Cat>
//
//    It is important to understand that we are dealing with a type system. All names referring to a part of
//    the living hierarchy are type.
//
//          "Cat, Mammal, Animal, List<Mammal>, List<Vertebrate>, List<Cat> are all different types"
//
//    Now let's explore the consequences of stating the ListPreservingLiskov hypothesis.
//
//    Exercise:
//
//    I. Following the rules of Liskov Principle
//
//          We will start the exercise by considering List<Mammal> because it is the central type of our hierarchy.
//          It will allow us to reason with the upper part of the tree or the lower part of the tree.
//
//          So if you think that the answer to some question is : List<Mammal> & List<Vertebrate> & List<Animal>
//          then you are referring to the upper part of the List<> Tree.
//          You can instead say that the answer is : all classes that are super(type) of Mammal.
//
//          And if you think that the answer to some question is : List<Mammal> & List<Felidae> & List<Cat>
//          then you are referring to the lower part of the List<> Tree.
//          You can instead say that the answer is : all classes that extend Mammal.
//
//      1. -> Can you list all subtypes of List<Mammal> ?
//
//      2. -> remember that Liskov principle can be seen as
//              - any property true for a type T should also be true for all subtypes S of T
//
//          Considering this, if a property is true for List<Mammal>, which other types should have that property ?
//
//      3.  Consider the following property p :
//          p(Type) = "I can add any Mammal instance to an instance of {Type}"
//
//          -> is property p true for Type = List<Mammal> ?
//          -> according to Liskov principle, which other types that property should also be true for ?
//
//      4.  "addBonusMammal" is a function that adds a Mammal instance to a list.
//          It is the embodiment of the property p(T).
//
//          The following method tries to call "addBonusMammal" for different types.
//          -> uncomment the lines corresponding to the types we determined it should work for.
//
//          It should not compile yet. It is perfectly normal, let it be.
    public static void followingLiskov() {

//        None of the calls below  compile at first except for Mammals.

//        addBonusMammal(animals);
//        addBonusMammal(vertebrates);
        addBonusMammal(mammals);
//        addBonusMammal(felidaes);
//        addBonusMammal(cats);
    }

    private static void addBonusMammal(List<Mammal> mammals) {
        // comment below as soon as it does not compile anymore
        mammals.add(randomBonusMammal());
    }

    private static Mammal randomBonusMammal() {
        return new Horse("Charles", Mammal.Fur.BLACK);
    }


    private static List<Cat> someList() {
        return Arrays.asList(
                new Cat("Felix", Mammal.Fur.BLACK_AND_WHITE),
                new Cat("Garfield", Mammal.Fur.ORANGE),
                new Cat("Madcat", Mammal.Fur.BLACK),
                new Cat("Grumpy Cat", Mammal.Fur.GREY)
        );
    }
}

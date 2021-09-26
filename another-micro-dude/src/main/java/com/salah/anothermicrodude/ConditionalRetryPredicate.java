package com.salah.anothermicrodude;

import java.util.function.Predicate;

public class ConditionalRetryPredicate implements Predicate<Ent> {
    @Override
    public boolean test(Ent ent) {
        return false;
    }
}

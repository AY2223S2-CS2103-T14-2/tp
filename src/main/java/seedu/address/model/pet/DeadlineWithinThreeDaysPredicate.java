package seedu.address.model.pet;


import java.time.LocalDateTime;
import java.util.function.Predicate;


/**
 * Tests that a {@code Pet}'s {@code Deadline} is within 3 days.
 */
public class DeadlineWithinThreeDaysPredicate implements Predicate<Pet> {

    public DeadlineWithinThreeDaysPredicate() {
    }

    @Override
    public boolean test(Pet pet) {
        Deadline d = pet.getDeadline();
        return LocalDateTime.now().isAfter(d.deadline.minusDays(3));
    }

    @Override
    public boolean equals(Object other) {
        return other == this ; // short circuit if same object

    }

}
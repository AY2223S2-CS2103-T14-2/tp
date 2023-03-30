package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.pet.Pet;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Pet> PREDICATE_SHOW_ALL_PETS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getPetPalFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setPetPalFilePath(Path petPalFilePath);

    /**
     * Replaces pet pal data with the data in {@code addressBook}.
     */
    void setPetPal(ReadOnlyPetPal petPal);

    /** Returns the PetPal */
    ReadOnlyPetPal getPetPal();

    /**
     * Returns true if a pet with the same identity as {@code pet} exists in the pet list.
     */
    boolean hasPet(Pet pet);

    /**
     * Deletes the given pet.
     * The pet must exist in the pet list.
     */
    void deletePet(Pet target);

    /**
     * Adds the given person.
     * {@code pet} must not already exist in the pet list.
     */
    void addPet(Pet pet);

    /**
     * Marks the given pet
     * The pet must exist in the pet list.
     */
    void markPet(Pet target);

    void undo();

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPet(Pet target, Pet editedPet);

    /**
     * Returns an unmodifiable view of the filtered pet list
     */
    ObservableList<Pet> getFilteredPetList();

    /**
     * Updates the filter of the filtered pet list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPetList(Predicate<Pet> predicate);

    /**
     * Deletes the given pet
     * This pet must exist in the PetPal list
     * @param petToArchive Pet object to archive
     */
    void archivePet(Pet petToArchive);

    ReadOnlyPetPal getPetPalArchive();
}

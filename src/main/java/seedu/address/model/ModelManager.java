package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.pet.Pet;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final PetPal petPal;
    private final PetPal petPalArchive;
    private final UserPrefs userPrefs;
    private final FilteredList<Pet> filteredPets;

    /**
     * Initializes a ModelManager with the given PetPal and userPrefs.
     */
    public ModelManager(ReadOnlyPetPal petPal, ReadOnlyPetPal petPalArchive, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(petPal, userPrefs);

        logger.info("Initializing with PetPal: " + petPal + " and user prefs " + userPrefs);

        this.petPal = new PetPal(petPal);
        this.petPalArchive = new PetPal(petPalArchive);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPets = new FilteredList<>(this.petPal.getPetList());
    }

    public ModelManager() {
        this(new PetPal(), new PetPal(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getPetPalFilePath() {
        return userPrefs.getPetPalFilePath();
    }

    @Override
    public void setPetPalFilePath(Path petPalFilePath) {
        requireNonNull(petPalFilePath);
        userPrefs.setPetPalFilePath(petPalFilePath);
    }

    public Path getPetPalArchiveFilePath() {
        return userPrefs.getPetPalArchiveFilePath();
    }

    public void setPetPalArchiveFilePath(Path petPalArchiveFilePath){
        requireNonNull(petPalArchiveFilePath);
        userPrefs.setPetPalArchiveFilePath(petPalArchiveFilePath);
    }

    //===================================== PetPal ======================================================

    @Override
    public void setPetPal(ReadOnlyPetPal petPal) {
        this.petPal.resetData(petPal);
    }

    @Override
    public ReadOnlyPetPal getPetPal() {
        return petPal;
    }

    public ReadOnlyPetPal getPetPalArchive() {
        return petPalArchive;
    }

    @Override
    public boolean hasPet(Pet pet) {
        requireNonNull(pet);
        return petPal.hasPet(pet);
    }

    @Override
    public void deletePet(Pet target) {
        petPal.removePet(target);
    }

    @Override
    public void addPet(Pet pet) {
        petPal.addPet(pet);
        updateFilteredPetList(PREDICATE_SHOW_ALL_PETS);
    }

    @Override
    public void setPet(Pet target, Pet editedPet) {
        requireAllNonNull(target, editedPet);

        petPal.setPet(target, editedPet);
    }

    @Override
    public void archivePet(Pet petToArchive) {
        requireNonNull(petToArchive);
        petPal.archivePet(petToArchive);
        updateFilteredPetList(PREDICATE_SHOW_ALL_PETS);
    }

    //=========== Filtered Pet List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedPetPal}
     */
    @Override
    public ObservableList<Pet> getFilteredPetList() {
        return filteredPets;
    }

    @Override
    public void updateFilteredPetList(Predicate<Pet> predicate) {
        requireNonNull(predicate);
        filteredPets.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return petPal.equals(other.petPal)
                && userPrefs.equals(other.userPrefs)
                && filteredPets.equals(other.filteredPets);
    }

}

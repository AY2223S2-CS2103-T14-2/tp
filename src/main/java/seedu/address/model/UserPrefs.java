package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
<<<<<<< HEAD
    private Path addressBookFilePath = Paths.get("data" , "addressbook.json");
    private Path archiveFilePath = Paths.get("data", "archive.json");
=======
    private Path petPalFilePath = Paths.get("data" , "petpal.json");
>>>>>>> 5ddbbe71d6d18725516fbc865f6283af0a45be56

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {}

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setPetPalFilePath(newUserPrefs.getPetPalFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getPetPalFilePath() {
        return petPalFilePath;
    }

    public void setPetPalFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        this.petPalFilePath = addressBookFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return guiSettings.equals(o.guiSettings)
                && petPalFilePath.equals(o.petPalFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, petPalFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal data file location : " + petPalFilePath);
        return sb.toString();
    }

}

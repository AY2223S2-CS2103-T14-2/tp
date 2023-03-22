package seedu.address.testutil;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.pet.Address;
import seedu.address.model.pet.Deadline;
import seedu.address.model.pet.Email;
import seedu.address.model.pet.Name;
import seedu.address.model.pet.OwnerName;
import seedu.address.model.pet.Pet;
import seedu.address.model.pet.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PetBuilder {

    public static final String DEFAULT_OWNER_NAME = "Amy Bee";
    public static final String DEFAULT_NAME = "Amy Bee Woof";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final LocalDateTime DEFAULT_TIMESTAMP = LocalDateTime.now();
    public static final Deadline DEFAULT_DEADLINE = new Deadline("Feed medicine", LocalDateTime.now());
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private OwnerName ownerName;
    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private LocalDateTime timestamp;
    private Deadline deadline;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PetBuilder() {
        ownerName = new OwnerName(DEFAULT_OWNER_NAME);
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        timestamp = DEFAULT_TIMESTAMP;
        deadline = DEFAULT_DEADLINE;
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code petToCopy}.
     */
    public PetBuilder(Pet petToCopy) {
        ownerName = petToCopy.getOwnerName();
        name = petToCopy.getName();
        phone = petToCopy.getPhone();
        email = petToCopy.getEmail();
        address = petToCopy.getAddress();
        timestamp = petToCopy.getTimeStamp();
        deadline = petToCopy.getDeadline();
        tags = new HashSet<>(petToCopy.getTags());
    }
    /**
     * Sets the {@code Name} of the {@code Pet} that we are building.
     */
    public PetBuilder withOwnerName(String ownerName) {
        this.ownerName = new OwnerName(ownerName);
        return this;
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PetBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PetBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PetBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PetBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PetBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Pet build() {
        return new Pet(ownerName, name, phone, email, address, timestamp, deadline, tags);
    }

}

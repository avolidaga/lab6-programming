package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import model.exceptions.FieldException;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@XStreamAlias("product")
public class Product implements Comparable<Product>, Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XStreamAlias("coordinates")
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double price; //Значение поля должно быть больше 0
    private String partNumber; //Поле может быть null
    private long manufactureCost;
    @XStreamAlias("unitOfMeasure")
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    @XStreamAlias("person")
    private Person owner; //Поле не может быть null

    public Product(String name, Coordinates coordinates, double price, String partNumber, long manufactureCost, UnitOfMeasure unitOfMeasure, Person owner) {
        this.setId(uniqueId());
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setCreationDate();
        this.setPrice(price);
        this.partNumber = partNumber;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.setOwner(owner);
    }

    public Product(long id, String name, Coordinates coordinates, LocalDate creationDate, double price, String partNumber, long manufactureCost, UnitOfMeasure unitOfMeasure, Person owner) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.partNumber = partNumber;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }



    /**
     *
     * @return id
     */
    private int uniqueId() {
        UUID uniqueKey = UUID.randomUUID();
        return Math.abs(uniqueKey.hashCode());
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param coordinates
     */

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate() {
        this.creationDate = LocalDate.now();
        if (creationDate == null){
            throw new FieldException("Exception: Field 'creationDate' can not be null \n Please try again");
        }

    }

    /**
     *
     * @param price
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param owner
     */

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return partNumber
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param o
     * @return
     */

    @Override
    public int compareTo(Product o) {
        return name.compareTo(o.getName());
    }

//    @Override
//    public int compareTo(model.Product o) {
//        return partNumber.compareTo(o.getPartNumber());
//    }

    public long getManufactureCost() {
        return manufactureCost;
    }

    public Long getId() {
        return id;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "Product :\n " +
                "Id : " + id +
                ",\n Name : '" + name + '\'' +
                ",\n Coordinates :" + coordinates.toString() +
                ",\n Creation date : " + creationDate.toString() +
                ",\n Price : " + price +
                ",\n Part number : '" + partNumber + '\'' +
                ",\n Manufacture cost : " + manufactureCost +
                ",\n Unit of measure : " + unitOfMeasure +
                ",\n Owner :  " + owner.toString();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public Person getOwner() {
        return owner;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setManufactureCost(long manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}

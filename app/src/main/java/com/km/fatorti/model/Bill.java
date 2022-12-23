package com.km.fatorti.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * used to store bill information, including dateOfIssue, company, its value and if it's paid or not
 * @author Karim Halayqa
 */
public class Bill implements Parcelable {
    private int id; // serial number
    private Date dateOfIssue;
    private Date dateOfPayment;
    private Company company;
    private double value;
    private Boolean paid;

    private User receiver;


    protected Bill(Parcel in) {
        id = in.readInt();
        value = in.readDouble();
        byte tmpPaid = in.readByte();
        paid = tmpPaid == 0 ? null : tmpPaid == 1;
    }

    public static final Creator<Bill> CREATOR = new Creator<Bill>() {
        @Override
        public Bill createFromParcel(Parcel in) {
            return new Bill(in);
        }

        @Override
        public Bill[] newArray(int size) {
            return new Bill[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Bill(int id, Date dateOfIssue, Date dateOfPayment, Company company, double value, Boolean paid, User receiver) {
        this.id = id;
        this.dateOfIssue = dateOfIssue;
        this.dateOfPayment = dateOfPayment;
        this.company = company;
        this.value = value;
        this.paid = paid;
        this.receiver = receiver;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String toString() {
        return dateFormat.format(dateOfIssue)+"     "+company.toString()+"     "+value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeDouble(value);
        parcel.writeByte((byte) (paid == null ? 0 : paid ? 1 : 2));
    }
}

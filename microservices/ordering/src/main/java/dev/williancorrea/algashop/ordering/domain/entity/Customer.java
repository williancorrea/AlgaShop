package dev.williancorrea.algashop.ordering.domain.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Setter;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter(AccessLevel.PRIVATE)
public class Customer implements Serializable {

  @Serial
  private static final long serialVersionUID = -8004238397647524479L;

  @EqualsAndHashCode.Include
  private UUID id;
  private String fullName;
  private LocalDate birthDate;
  private String email;
  private String phone;
  private String document;
  private Boolean promotionNotificationsAllowed;
  private Boolean archived;
  private OffsetDateTime registeredAt;
  private OffsetDateTime archivedAt;
  private int loyaltyPoints;

  public Customer(UUID id, String fullName, LocalDate birthDate, String email, String phone, String document,
                  Boolean promotionNotificationsAllowed, OffsetDateTime registeredAt) {
    this.id = id;
    this.fullName = fullName;
    this.birthDate = birthDate;
    this.email = email;
    this.phone = phone;
    this.document = document;
    this.promotionNotificationsAllowed = promotionNotificationsAllowed;
    this.registeredAt = registeredAt;
  }

  public Customer(UUID id,
                  String fullName,
                  LocalDate birthDate,
                  String email,
                  String phone,
                  String document,
                  Boolean promotionNotificationsAllowed,
                  Boolean archived,
                  OffsetDateTime registeredAt,
                  OffsetDateTime archivedAt,
                  Integer loyaltyPoints) {
    this.id = id;
    this.fullName = fullName;
    this.birthDate = birthDate;
    this.email = email;
    this.phone = phone;
    this.document = document;
    this.promotionNotificationsAllowed = promotionNotificationsAllowed;
    this.archived = archived;
    this.registeredAt = registeredAt;
    this.archivedAt = archivedAt;
    this.loyaltyPoints = loyaltyPoints;
  }

  public void addLoyaltyPoints(Integer points) {
    this.loyaltyPoints += points;
  }

  public void archive() {
    this.setArchived(true);
  }

  public void enablePromotionNotifications() {
    this.setPromotionNotificationsAllowed(true);
  }

  public void disablePromotionNotifications() {
    this.setPromotionNotificationsAllowed(false);
  }

  public void changeName(String fullName) {
    this.setFullName(fullName);

  }

  public void changeEmail(String email) {
    this.setEmail(email);
  }

  public void changePhone(String phone) {
    this.setPhone(phone);
  }

  public UUID id() {
    return id;
  }

  public String fullName() {
    return fullName;
  }

  public LocalDate birthDate() {
    return birthDate;
  }

  public String email() {
    return email;
  }

  public String phone() {
    return phone;
  }

  public String document() {
    return document;
  }

  public Boolean iPromotionNotificationsAllowed() {
    return promotionNotificationsAllowed;
  }

  public Boolean isArchived() {
    return archived;
  }

  public OffsetDateTime registeredAt() {
    return registeredAt;
  }

  public OffsetDateTime archivedAt() {
    return archivedAt;
  }

  public Integer loyaltyPoints() {
    return loyaltyPoints;
  }
}

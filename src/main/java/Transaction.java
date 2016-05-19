public class Transaction {
  private String name;
  private String surname;
  private String src_iban;
  private String dst_iban;
  private Float amount;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getSrc_iban() {
    return src_iban;
  }

  public void setSrc_iban(String src_iban) {
    this.src_iban = src_iban;
  }

  public String getDst_iban() {
    return dst_iban;
  }

  public void setDst_iban(String dst_iban) {
    this.dst_iban = dst_iban;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }
}

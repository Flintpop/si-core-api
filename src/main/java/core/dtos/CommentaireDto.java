package core.dtos;

import java.util.Date;

public class CommentaireDto {

  private Integer id;
  private Integer auteurId;
  private Date dateMessage;
  private Integer evenementId;
  private String texte;

  // Getters et Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAuteurId() {
    return auteurId;
  }

  public void setAuteurId(Integer auteurId) {
    this.auteurId = auteurId;
  }

  public Date getDateMessage() {
    return dateMessage;
  }

  public void setDateMessage(Date dateMessage) {
    this.dateMessage = dateMessage;
  }

  public Integer getEvenementId() {
    return evenementId;
  }

  public void setEvenementId(Integer evenementId) {
    this.evenementId = evenementId;
  }

  public String getTexte() {
    return texte;
  }

  public void setTexte(String texte) {
    this.texte = texte;
  }
}

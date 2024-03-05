package core.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class InscriptionId implements Serializable {
  private int membreId;
  private int evenementId;

  public InscriptionId() {
  }

  public InscriptionId(int membreId, int evenementId) {
    this.membreId = membreId;
    this.evenementId = evenementId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof InscriptionId)) return false;
    InscriptionId that = (InscriptionId) o;
    return membreId == that.membreId && evenementId == that.evenementId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(membreId, evenementId);
  }
}

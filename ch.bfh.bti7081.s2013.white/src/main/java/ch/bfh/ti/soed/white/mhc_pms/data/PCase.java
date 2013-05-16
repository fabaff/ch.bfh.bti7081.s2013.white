package ch.bfh.ti.soed.white.mhc_pms.data;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsItem;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Entity implementation class for Entity: PCase
 *
 */
@Entity
@Table(name = "PCase")
public class PCase extends MhcPmsItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	private String reanimationsstatus = "";
	
	@NotNull
	private String zuweiser = "";
	
	@ManyToOne
//	@JoinColumn(name="pid")
	private Patient patient;
	
	public PCase() {
		// TODO restliche Felder
		// TODO restliche Container
	}
	
	public PCase(Patient pat) {
		this.patient = pat;
	}
	
	@Override
	protected void setCurrentContainer() {
		// TODO update weitergeben an andere Container
		
	}

	/**
	 * @return the reanimationsstatus
	 */
	public String getReanimationsstatus() {
		return reanimationsstatus;
	}

	/**
	 * @param reanimationsstatus the reanimationsstatus to set
	 */
	public void setReanimationsstatus(String reanimationsstatus) {
		this.reanimationsstatus = reanimationsstatus;
	}

	/**
	 * @return the zuweiser
	 */
	public String getZuweiser() {
		return this.zuweiser;
	}

	/**
	 * @param zuweiser the zuweiser to set
	 */
	public void setZuweiser(String zuweiser) {
		this.zuweiser = zuweiser;
	}
   
}

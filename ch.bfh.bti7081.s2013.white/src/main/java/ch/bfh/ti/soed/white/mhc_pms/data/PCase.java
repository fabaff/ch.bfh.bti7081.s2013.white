package ch.bfh.ti.soed.white.mhc_pms.data;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsItem;
import java.io.Serializable;
import java.util.Date;

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
	
	private String suizidal = "";
	
	private String fremdgefaerdung = "";
	
	private String ausgang = "";
	
	private String urlaub = "";
	
	private String juristischerStatus = "";
	
	private String zwangsmassnahmen = "";
	
	private String patVerfuegung = "";
	
	@Temporal(value = TemporalType.DATE)
	private Date dateCaseOpened;
	
	@Temporal(value = TemporalType.DATE)
	private Date dateCaseClosed;
	
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

	/**
	 * @return the suizidal
	 */
	public String getSuizidal() {
		return suizidal;
	}

	/**
	 * @param suizidal the suizidal to set
	 */
	public void setSuizidal(String suizidal) {
		this.suizidal = suizidal;
	}

	/**
	 * @return the fremdgefaerdung
	 */
	public String getFremdgefaerdung() {
		return fremdgefaerdung;
	}

	/**
	 * @param fremdgefaerdung the fremdgefaerdung to set
	 */
	public void setFremdgefaerdung(String fremdgefaerdung) {
		this.fremdgefaerdung = fremdgefaerdung;
	}

	/**
	 * @return the ausgang
	 */
	public String getAusgang() {
		return ausgang;
	}

	/**
	 * @param ausgang the ausgang to set
	 */
	public void setAusgang(String ausgang) {
		this.ausgang = ausgang;
	}

	/**
	 * @return the urlaub
	 */
	public String getUrlaub() {
		return urlaub;
	}

	/**
	 * @param urlaub the urlaub to set
	 */
	public void setUrlaub(String urlaub) {
		this.urlaub = urlaub;
	}

	/**
	 * @return the juristischerStatus
	 */
	public String getJuristischerStatus() {
		return juristischerStatus;
	}

	/**
	 * @param juristischerStatus the juristischerStatus to set
	 */
	public void setJuristischerStatus(String juristischerStatus) {
		this.juristischerStatus = juristischerStatus;
	}

	/**
	 * @return the zwangsmassnahmen
	 */
	public String getZwangsmassnahmen() {
		return zwangsmassnahmen;
	}

	/**
	 * @param zwangsmassnahmen the zwangsmassnahmen to set
	 */
	public void setZwangsmassnahmen(String zwangsmassnahmen) {
		this.zwangsmassnahmen = zwangsmassnahmen;
	}

	/**
	 * @return the patVerfuegung
	 */
	public String getPatVerfuegung() {
		return patVerfuegung;
	}

	/**
	 * @param patVerfuegung the patVerfuegung to set
	 */
	public void setPatVerfuegung(String patVerfuegung) {
		this.patVerfuegung = patVerfuegung;
	}

	/**
	 * @return the dateCaseOpened
	 */
	public Date getDateCaseOpened() {
		return dateCaseOpened;
	}

	/**
	 * @param dateCaseOpened the dateCaseOpened to set
	 */
	public void setDateCaseOpened(Date dateCaseOpened) {
		this.dateCaseOpened = dateCaseOpened;
	}

	/**
	 * @return the dateCaseClosed
	 */
	public Date getDateCaseClosed() {
		return dateCaseClosed;
	}

	/**
	 * @param dateCaseClosed the dateCaseClosed to set
	 */
	public void setDateCaseClosed(Date dateCaseClosed) {
		this.dateCaseClosed = dateCaseClosed;
	}
   
	
}

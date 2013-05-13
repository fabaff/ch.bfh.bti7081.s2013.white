package ch.bfh.ti.soed.white.mhc_pms.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.vaadin.addon.jpacontainer.EntityProvider;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.provider.CachingMutableLocalEntityProvider;

public class PmsDataContainer<E extends PmsItem> extends JPAContainer<E> implements Set<E> {

	private static final long serialVersionUID = 5430581999993870449L;

	private Set<E> dataContainer;
	
	public PmsDataContainer(Class<E> entityClass) {
		super(entityClass);

		this.dataContainer = new HashSet<E>();
		// TODO set currentRecordId in Constructor
		// TODO persistence unit nicht als String angeben
		EntityProvider<E> entityProvider = new CachingMutableLocalEntityProvider<E>(
				entityClass,
				JPAContainerFactory
						.createEntityManagerForPersistenceUnit("ch.bfh.bti7081.s2013.white"));
		
		this.setEntityProvider(entityProvider);
		this.setAutoCommit(true);
	}

	@Override
	public boolean isEmpty() {
		return this.dataContainer.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this.dataContainer.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return this.dataContainer.iterator();
	}

	@Override
	public Object[] toArray() {
		return this.dataContainer.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO korrekten Pyp P spezifizieren
		return this.dataContainer.toArray(a);
	}

	@Override
	public boolean add(E e) {
		return this.dataContainer.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return this.dataContainer.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.dataContainer.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return this.dataContainer.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return this.dataContainer.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return this.dataContainer.retainAll(c);
	}

	@Override
	public void clear() {
		this.dataContainer.clear();
	}
}

package ch.bfh.ti.soed.white.mhc_pms.data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.EntityProvider;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.provider.CachingBatchableLocalEntityProvider;
import com.vaadin.addon.jpacontainer.provider.CachingMutableLocalEntityProvider;

public class MhcPmsContainer<E extends MhcPmsItem> extends JPAContainer<E>
		implements Set<E> {

	private static final long serialVersionUID = 5430581999993870449L;

	private Set<E> dataContainer;

	private E currentItem;
	
	private MhcPmsDataAccess dataAccess;

	public MhcPmsContainer(Class<E> entityClass, MhcPmsDataAccess dataAccess) {
		super(entityClass);

		this.dataAccess = dataAccess;
		this.dataContainer = new HashSet<E>();

		// TODO persistence unit nicht als String angeben
		EntityProvider<E> entityProvider = new CachingBatchableLocalEntityProvider<E>(
				entityClass,
				JPAContainerFactory
						.createEntityManagerForPersistenceUnit("ch.bfh.bti7081.s2013.white"));
		this.setEntityProvider(entityProvider);
		this.setAutoCommit(true);

		Collection<?> collection = this.getItemIds();
		if (!collection.isEmpty()) {
			this.currentItem = this.getItem(collection.iterator().next())
					.getEntity();
		}
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

	public boolean incrementCurrentItem() {
		if (this.size() != 0) {
			// TODO id in Oberklasse
			return this.setCurrentItem((((Patient) this.currentItem).getId() + 1) % this.size());
		} else {
			return false;
		}
	}

	public boolean decrementCurrentItem() {
		if (this.size() != 0) {
			// TODO id in Oberklasse
			int idDecrement = ((Patient) this.currentItem).getId() - 1;
			return this.setCurrentItem(idDecrement > 0 ? idDecrement : this.size() - 1);
		} else {
			return false;
		}
	}

	public boolean setCurrentItem(Object value) {
		EntityItem<E> entityItem = this.getItem(value);
		if (entityItem != null) {
			this.currentItem = entityItem.getEntity();
			
			return true;
		} else {
			return false;
		}
	}

	public E getCurrentItem() {
		return this.currentItem;
	}
}

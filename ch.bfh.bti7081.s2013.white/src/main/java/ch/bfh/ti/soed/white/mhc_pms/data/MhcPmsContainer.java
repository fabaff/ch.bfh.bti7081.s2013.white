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

	private EntityItem<E> currentItem;
	
	public MhcPmsContainer(Class<E> entityClass) {
		super(entityClass);

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
			this.currentItem = this.getItem(collection.iterator().next());
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
			Object id = this.currentItem.getItemId();
			if (this.isLastId(id)) {
				id = this.firstItemId();
			} else {
				id = this.nextItemId(id);
			}
			return this.setCurrentItem(id);
		} else {
			return false;
		}
	}

	public boolean decrementCurrentItem() {
		if (this.size() != 0) {
			Object id = this.currentItem.getItemId();
			if (this.isFirstId(id)) {
				id = this.lastItemId();
			} else {
				id = this.prevItemId(id);
			}
			return this.setCurrentItem(id);
		} else {
			return false;
		}
	}

	public boolean setCurrentItem(Object id) {
		
		EntityItem<E> entityItem = this.getItem(id);
		if (entityItem != null) {
			this.currentItem = entityItem;
			this.currentItem.getEntity().setCurrentContainer();
			return true;
		} else {
			return false;
		}
	}

	public EntityItem<E> getCurrentItem() {
		return this.currentItem;
	}
}

package mainview;

import java.util.HashSet;
import java.util.Iterator;

public class SellItemHashSet extends HashSet<SellItemView>{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(SellItemView e) {
		Iterator<SellItemView> iterator = iterator();
		while (iterator.hasNext()) {
			if(iterator.next().getId()==e.getId()) {
				return false;
			}
		}
		return super.add(e);
	}
}

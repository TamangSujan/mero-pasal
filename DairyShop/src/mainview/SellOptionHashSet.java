package mainview;

import java.util.HashSet;
import java.util.Iterator;

public class SellOptionHashSet extends HashSet<ListOptionButton>{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(ListOptionButton e) {
		Iterator<ListOptionButton> iterator = iterator();
		while (iterator.hasNext()) {
			if(iterator.next().getName()==e.getName()) {
				return false;
			}
		}
		return super.add(e);
	}
}

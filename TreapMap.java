import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TreapMap<K extends Comparable<K>, V> implements Map<K, V>
{
	
	private static Random random = new Random();
	
	public interface PriorityProvider
	{
		int nextPriotity();
	}
	
	private int nextPriority()
	{
		return random.nextInt();
	}
			
	private class TreapNode
	{
		 TreapNode left; 
		 TreapNode right;
		 K key; 
		 V value;
		 int priority; 
	}
	
	private TreapNode root;	
	
	private class NodesAfterSplit
	{
		private TreapNode l, r;
		NodesAfterSplit(TreapNode l, TreapNode r)
		{
			this.l = l;
			this.r = r;
		}
	}
		
	private TreapNode merge(TreapNode leftTreap, TreapNode rightTreap)
	{
		if (leftTreap == null)
			return rightTreap;
		if (rightTreap == null)
			return leftTreap;

		if (leftTreap.priority >= rightTreap.priority) 
		{
			leftTreap.right = merge (leftTreap.right, rightTreap);
			return leftTreap;
		}
		else 
		{
			rightTreap.left = merge (leftTreap, rightTreap.left);
			return rightTreap;
		}
	}
		
	private NodesAfterSplit split (TreapNode root, K x)
	{
		if (root == null)
		{
			return new NodesAfterSplit(null, null);
		}
		else
		if (x.compareTo(root.key) < 0)
		{
			NodesAfterSplit variable = split (root.left, x);
			root.left = variable.r;
			variable.r = root;
			return variable;		
		}
		else
		{
			NodesAfterSplit variable = split (root.right, x);
			root.right = variable.l;			
			variable.l = root;
			return variable;
		}
	}
	
	TreapNode search(TreapNode root, Object keyObject)
	{
		@SuppressWarnings("unchecked")
		K key = (K) keyObject;
		if (root == null)
			return null;
		else
		if (root.key.compareTo(key) == 0)
			return root;
		else
		{
			if (key.compareTo(root.key) < 0)
				return search (root.left, key);
			else
				return search (root.right, key);
		}
	}	
	

	@Override
	public void clear()
	{
		root = null;
	}



	@Override
	public boolean containsKey(Object key)
	{
		if (search(root, key) != null)
			return true;
		return false;
	}



	@Override
	public boolean containsValue(Object value)
	{
		throw new RuntimeException("Метод не определен");
	}



	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet()
	{
		throw new RuntimeException("Метод не определен");
	}



	@Override
	public V get(Object key)
	{
		TreapNode searchNode = search(root, key);
		if (searchNode != null)
			return searchNode.value;
		return null;
	}



	@Override
	public boolean isEmpty()
	{
		return root == null;
	}



	@Override
	public Set<K> keySet()
	{
		throw new RuntimeException("Метод не определен");
	}



	@Override
	public V put(K key, V value)
	{	

		TreapNode searchNode = search(root, key);
		if (searchNode != null)
		{
			V returnValue = searchNode.value;
			searchNode.value = value;
			return returnValue;
		}
		
		TreapNode newNode = new TreapNode();
		newNode.key = key;
		newNode.value = value;
		newNode.priority = nextPriority();	
		newNode.left = newNode.right = null;
		
		NodesAfterSplit splitTree = split (root, key);	
		
		root = merge (merge (splitTree.l, newNode), splitTree.r);

		
		return value;
	}



	@Override
	public void putAll(Map<? extends K, ? extends V> m)
	{
		// TODO Auto-generated method stub	
	}


	

	@Override
	public V remove(Object key)
	{
		return delete(null, root, key);	 
	}



	private V delete(TreapNode previousNode, TreapNode node, Object keyObject)
	{
		@SuppressWarnings("unchecked")
		K key = (K) keyObject;
		
		if (node == null)
			return null;
		
		if (node.key.compareTo(key) == 0)
		{
			if (previousNode == null)
				root = merge (node.left, node.right);
			else
			{
				if (key.compareTo(previousNode.key) < 0)
					previousNode.left = merge (node.left, node.right);
				else
					previousNode.right = merge (node.left, node.right);	
			}
			return node.value;		
		}
			
		if (key.compareTo(node.key) < 0)
				delete(node, node.left, key);
			else
				delete(node, node.right, key);
		
		return null;
	}
	

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		throw new RuntimeException("Метод не определен");
	}



	@Override
	public Collection<V> values()
	{
		throw new RuntimeException("Метод не определен");
	}		
}

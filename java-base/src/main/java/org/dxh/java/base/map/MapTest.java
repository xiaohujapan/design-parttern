package org.dxh.java.base.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Class Name		: MapTest<br>
 * Description		: マップテスト用クラス<br>
 * @author dxh
 * @since 1.8
 */
public class MapTest {

	public static void main(String[] args) {
		//１０万件のデータのスピート比較
		//CompareMapSpeed(100000);
		
		//全件抽出の比較
		//OutPutAllMapValue(100000,MapType.HashMap);
		
		//抽出内容の順番のチェック
		OutPutMapValueOrder(20,MapType.HashMap);
		OutPutMapValueOrder(20,MapType.TreeMap);
		OutPutMapValueOrder(20,MapType.Hashtable);
		OutPutMapValueOrder(20,MapType.LinkedHashMap);

	}
	
	/**
	 * Method Name				: Map全件抽出<br>
	 * Description					: Map全件抽出方法<br>
	 * @param なし
	 * @return なし
	 * @throws なし
	*/
	public static void OutPutMapValueOrder(int size,MapType mapType) {
		Map<String,String> testMap = null;
		if(mapType.equals(MapType.HashMap)) {
			testMap = new HashMap<String,String>();
		}else if(mapType.equals(MapType.LinkedHashMap)) {
			testMap = new LinkedHashMap<String,String>();
		}else if(mapType.equals(MapType.TreeMap)) {
			testMap = new TreeMap<String,String>();
		}else if(mapType.equals(MapType.Hashtable)) {
			testMap = new Hashtable<String,String>();
		}
		testMap.put("30",UUID.randomUUID().toString() );
		for(int i=0;i<size;i++) {
			testMap.put(Integer.toString(i),UUID.randomUUID().toString() );
		}

		System.out.println("==========" + mapType + "=================");
		Iterator<Map.Entry<String,String>> mapIterator = testMap.entrySet().iterator();
		while(mapIterator.hasNext()) {
			Map.Entry<String,String> entry = mapIterator.next();
			System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
		}
		System.out.println("==========" + mapType + "=================");
		testMap.clear();
	}
	
	/**
	 * Method Name				: Map全件抽出<br>
	 * Description					: Map全件抽出方法<br>
	 * @param なし
	 * @return なし
	 * @throws なし
	*/
	public static void OutPutAllMapValue(int size,MapType mapType) {
		Map<String,String> testMap = null;
		if(mapType.equals(MapType.HashMap)) {
			testMap = new HashMap<String,String>();
		}else if(mapType.equals(MapType.LinkedHashMap)) {
			testMap = new LinkedHashMap<String,String>();
		}else if(mapType.equals(MapType.TreeMap)) {
			testMap = new TreeMap<String,String>();
		}else if(mapType.equals(MapType.Hashtable)) {
			testMap = new Hashtable<String,String>();
		}
		for(int i=0;i<size;i++) {
			testMap.put(UUID.randomUUID().toString(), "test" + i);
		}
		
		System.out.println("==========" + mapType + "=================");
		long start = System.currentTimeMillis();
		for(String key:testMap.keySet()) {
			//System.out.println("key=" + key + ",value=" + testMap.get(key));
		}
		long end = System.currentTimeMillis();
		System.out.println("KeySet For Each　「" + size + "」 抽出の時間は[" +  (end-start) +  "]");
		
		start = System.currentTimeMillis();
		for(Map.Entry<String,String> entry:testMap.entrySet()) {
			//System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
		}
		end = System.currentTimeMillis();
		System.out.println("EntrySet For Each　「" + size + "」 抽出の時間は[" +  (end-start) +  "]");
		
		start = System.currentTimeMillis();
		Iterator<String> keyIterator = testMap.keySet().iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			//System.out.println("key=" + key + ",value=" + testMap.get(key));
		}
		end = System.currentTimeMillis();
		System.out.println("KeySet Iterator　「" + size + "」 抽出の時間は[" +  (end-start) +  "]");
		
		
		start = System.currentTimeMillis();
		Iterator<Map.Entry<String,String>> mapIterator = testMap.entrySet().iterator();
		while(mapIterator.hasNext()) {
			Map.Entry<String,String> entry = mapIterator.next();
			//System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
		}
		end = System.currentTimeMillis();
		System.out.println("EntrySet Iterator　「" + size + "」 抽出の時間は[" +  (end-start) +  "]");
		System.out.println("==========" + mapType + "=================");
		testMap.clear();
	}
	
	
	/**
	 * Method Name				: CompareMapSpeed<br>
	 * Description					:  HashMap Hashtable TreeMap LinkedHashMapの検索スピートのテスト<br>
	 * @param なし
	 * @return なし
	 * @throws なし
	*/
	public static void CompareMapSpeed(int size) {
		//HashMapの挿入
		Map<String,String> hashMap = new HashMap<String,String>();
		long start = System.currentTimeMillis();
		for(int i=0;i<size;i++) {
			hashMap.put(UUID.randomUUID().toString(), "test" + i);
		}
		long end = System.currentTimeMillis();
		System.out.println("HashMap" + size + "件データの挿入時間は[" +  (end-start) +  "]");
		
		//LinkedHashMap の挿入
		Map<String,String> linkHashMap = new LinkedHashMap<String,String>();
		start = System.currentTimeMillis();
		for(int i=0;i<size;i++) {
			linkHashMap.put(UUID.randomUUID().toString(), "test" + i);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedHashMap" + size + "件データの挿入時間は[" +  (end-start) +  "]");
		
		//TreeMapの挿入
		Map<String,String> treeMap = new TreeMap<String,String>();
		start = System.currentTimeMillis();
		for(int i=0;i<size;i++) {
			treeMap.put(UUID.randomUUID().toString(), "test" + i);
		}
		end = System.currentTimeMillis();
		System.out.println("TreeMap" + size + "件データの挿入時間は[" +  (end-start) +  "]");
		
		//Hashtable挿入
		Map<String,String> hashTable = new Hashtable<String,String>();
		start = System.currentTimeMillis();
		for(int i=0;i<size;i++) {
			hashTable.put(UUID.randomUUID().toString(), "test" + i);
		}
		end = System.currentTimeMillis();
		System.out.println("Hashtable" + size + "件データの挿入時間は[" +  (end-start) +  "]");
		
		//HashMapの抽出(for)
		start = System.currentTimeMillis();
		for(String key:hashMap.keySet()) {
			hashMap.get(key);
		}
		end = System.currentTimeMillis();
		System.out.println("HashMap" + size + "件データの抽出時間は[" +  (end-start) +  "]");
		
		//LinkedHashMapの抽出
		start = System.currentTimeMillis();
		for(String key:linkHashMap.keySet()) {
			linkHashMap.get(key);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedHashMap" + size + "件データの抽出時間は[" +  (end-start) +  "]");
		
		//TreeMapの抽出
		start = System.currentTimeMillis();
		for(String key:treeMap.keySet()) {
			treeMap.get(key);
		}
		end = System.currentTimeMillis();
		System.out.println("TreeMap" + size + "件データの抽出時間は[" +  (end-start) +  "]");
		
		//Hashtableの抽出
		start = System.currentTimeMillis();
		for(String key:hashTable.keySet()) {
			hashTable.get(key);
		}
		end = System.currentTimeMillis();
		System.out.println("Hashtable" + size + "件データの抽出時間は[" +  (end-start) +  "]");
		
	}

}

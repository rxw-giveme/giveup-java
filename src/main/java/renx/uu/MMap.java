package renx.uu;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class MMap {

	public Map map = null;

	public Set keySet() {
		if (this.map == null)
			return null;
		else {
			return this.map.keySet();
		}
	}

	public static MMap build(Map map) {
		if (map == null)
			return new MMap();
		else {
			MMap mapp = new MMap();
			mapp.map = map;
			return mapp;
		}
	}

	public static MMap build() {
		return build(null);
	}

	public MMap put(Object key, Object value, boolean iff) {
		if (iff) {
			put(key, value);
		}
		return this;
	}

	public MMap put(Object key, Object value) {
		if (this.map == null)
			this.map = new LinkedHashMap();
		if (value instanceof MMap)
			value = ((MMap) value).map;
		if (value instanceof Paramm)
			value = ((Paramm) value).value;
		this.map.put(key, value);
		return this;
	}

	public MMap putAll(Map map) {
		if (this.map == null)
			this.map = new LinkedHashMap();
		if (map != null) {
			this.map.putAll(map);
		}
		return this;
	}

	public MMap putAll(MMap mmap) {
		if (this.map == null)
			this.map = new LinkedHashMap();
		if (mmap.map != null) {
			this.map.putAll(mmap.map);
		}
		return this;
	}

	public Object get(Object key) {
		if (this.map == null)
			return null;
		return map.get(key);
	}

	public Object remove(Object key) {
		if (this.map == null)
			return null;
		return map.remove(key);
	}

	public String getString(Object key) {
		if (map == null)
			return null;
		return Paramm.toString(map.get(key));
	}

	public Boolean getBoolean(Object key) {
		if (map == null)
			return null;
		return Paramm.toBoolean(map.get(key));
	}

	public Integer getInteger(Object key) {
		if (map == null)
			return null;
		return Paramm.toInteger(map.get(key));
	}

	public Long getLong(Object key) {
		if (map == null)
			return null;
		return Paramm.toLong(map.get(key));
	}

	public BigDecimal getDecimal(Object key) {
		if (map == null)
			return null;
		return Paramm.toDecimal(map.get(key));
	}

	public Float getFloat(Object key) {
		if (map == null)
			return null;
		return Paramm.toFloat(map.get(key));
	}

	public Date getDate(Object key) {
		if (map == null)
			return null;
		return Paramm.toDate(map.get(key));
	}

	public LList getList(Object key) {
		if (map == null)
			return LList.build();
		return LList.build((List) map.get(key));
	}

	public MMap getMap(Object key) {
		if (map == null)
			return MMap.build();
		return MMap.build((Map) map.get(key));
	}

	public boolean isEmpty() {
		if (this.map == null)
			return true;
		else
			return this.map.isEmpty();
	}

	public boolean notEmpty() {
		return !isEmpty();
	}

	@Override
	public String toString() {
		return this.map == null ? null : this.map.toString();
	}

	public String toJSONString() {
		return JSON.toJSONString(this.map);
	}

	public String toJSONString(SerializerFeature... features) {
		return JSON.toJSONString(this.map, features);
	}
}

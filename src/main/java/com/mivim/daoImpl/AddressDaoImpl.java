package com.mivim.daoImpl;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mivim.dao.AddressDao;
import com.mivim.data.dao.AddressMapper;
import com.mivim.data.dao.ShippingaddressMapper;
import com.mivim.data.model.Address;
import com.mivim.data.model.Shippingaddress;
import com.mivim.data.model.ShippingaddressExample;
import com.mivim.dto.AddressDto;

@Repository
@Resource(name = "addressDaoImpl")
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private ShippingaddressMapper shippingaddressMapper;

	@Autowired
	@Qualifier("address")
	Address address;

	@Autowired
	@Qualifier("shippingaddress")
	Shippingaddress shippingaddress;

	@Autowired
	@Qualifier("shippingaddressExample")
	ShippingaddressExample shippingaddressExample;

	private static String id = Utils.getUUId();
	private static int status = Utils.getStatusCode();
	private static Date date = Utils.getDate();

	@Override
	public boolean sendAddress(AddressDto addressdto) {
		address.setId(id);
		address.setAddressLine1(addressdto.getAddressLine1());
		address.setAddressLine2(addressdto.getAddressLine2());
		address.setCity(addressdto.getCity());
		address.setStatus(status);
		address.setState(addressdto.getState());
		address.setPincode(addressdto.getPincode());
		address.setUpdatedDate(date);
		address.setUserId("1235");

		int status = addressMapper.insert(address);
		if (status != 0)
			return true;
		else
			return false;
	}

	@Override
	public int saveShippingAddress() {

		shippingaddress.setId(Utils.getUUId());
		shippingaddress.setAddressId(id);
		int status = shippingaddressMapper.insert(shippingaddress);
		return status;

	}

	@Override
	public String getShippingAddressId() {
		shippingaddressExample.or().andAddressIdEqualTo(id);
		List<Shippingaddress> list = shippingaddressMapper.selectByExample(shippingaddressExample);
		String shippingAddressId = null;
		for (Shippingaddress shippingaddress : list) {
			shippingAddressId = shippingaddress.getId();
		}
		shippingaddressExample.clear();
		return shippingAddressId;
	}

}

package address;

import java.util.Iterator;
import java.util.List;

//DAO -- db process
//DTO -- valeus

public class AddressTest {

	public static void main(String[] args) {
		AddressDAO dao = new AddressDAO();
		// create(dao);
		// read(dao);
		// update(dao);
		// delete(dao);
		list(dao);
	}

	private static void list(AddressDAO dao) {
		List<AddressDTO> list = dao.list();
		Iterator<AddressDTO> iter = list.iterator();
		while (iter.hasNext()) {
			AddressDTO dto = iter.next();
			p(dto);
			p("------------------");
		}
	}

	private static void delete(AddressDAO dao) {
		if (dao.delete(11)) {
			p("���� ����");
		} else {
			p("���� ����");
		}
	}

	private static void update(AddressDAO dao) {
		AddressDTO dto = dao.read(6);
		dto.setName("������");
		dto.setHandphone("000-123-456");
		dto.setAddress("����");

		if (dao.update(dto)) {
			p("������Ʈ ����");
		} else {
			p("������Ʈ ����");
		}
	}

	private static void read(AddressDAO dao) {
		AddressDTO dto = dao.read(10);
		p(dto);
	}

	private static void create(AddressDAO dao) {
		AddressDTO dto = new AddressDTO();

		dto.setName("������");
		dto.setHandphone("010-4033-2290");
		dto.setAddress("��⵵ ���ֽ�");

		if (dao.create(dto)) {
			p("����");
		} else {
			p("����");
		}
	}

	private static void p(String str) {
		System.out.println(str);
	}

	private static void p(AddressDTO dto) {
		if (dto != null) {
			p("��ȣ:" + dto.getAddressnum());
			p("�̸�:" + dto.getName());
			p("��ȭ��ȣ:" + dto.getHandphone());
			p("�ּ�:" + dto.getAddress());
		} else {
			p("��ȸ�� �����Ͱ� �����ϴ�");
		}
	}
}

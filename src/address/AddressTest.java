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
			p("삭제 성공");
		} else {
			p("삭제 실패");
		}
	}

	private static void update(AddressDAO dao) {
		AddressDTO dto = dao.read(6);
		dto.setName("이지훈");
		dto.setHandphone("000-123-456");
		dto.setAddress("운정");

		if (dao.update(dto)) {
			p("업데이트 성공");
		} else {
			p("업데이트 실패");
		}
	}

	private static void read(AddressDAO dao) {
		AddressDTO dto = dao.read(10);
		p(dto);
	}

	private static void create(AddressDAO dao) {
		AddressDTO dto = new AddressDTO();

		dto.setName("이지훈");
		dto.setHandphone("010-4033-2290");
		dto.setAddress("경기도 파주시");

		if (dao.create(dto)) {
			p("성공");
		} else {
			p("실패");
		}
	}

	private static void p(String str) {
		System.out.println(str);
	}

	private static void p(AddressDTO dto) {
		if (dto != null) {
			p("번호:" + dto.getAddressnum());
			p("이름:" + dto.getName());
			p("전화번호:" + dto.getHandphone());
			p("주소:" + dto.getAddress());
		} else {
			p("조회된 데이터가 없습니다");
		}
	}
}

package memo;

import java.util.Iterator;
import java.util.List;

public class MemoTest {

	public static void main(String[] args) {
		MemoDAO dao = new MemoDAO();
		// create(dao);
		// read(dao);
		// update(dao);
		// delete(dao);
		 list(dao);
	}

	private static void list(MemoDAO dao) {
		List<MemoDTO> list = dao.list();
		System.out.println("�� �Խù� : " + list.size());
		if (list.size() > 0) {
			Iterator<MemoDTO> iter = list.iterator();
			while (iter.hasNext()) {
				p(iter.next());
			}
		} else {
			p("��ȸ�� ������ �����ϴ�");
		}
	}

	private static void delete(MemoDAO dao) {
		if (dao.delete(1)) {
			p("���ڵ� ���� ����");
		} else {
			p("���ڵ� ���� ����");
		}

	}

	private static void update(MemoDAO dao) {
		MemoDTO dto = dao.read(1);
		dto.setName("��浿");
		dto.setContent("����� ����");
		if (dao.update(dto)) {
			p("������Ʈ ����");
		} else {
			p("������Ʈ ����");
		}
	}

	private static void read(MemoDAO dao) {
		MemoDTO dto = dao.read(1);
		if (dto != null) {
			p(dto);
		} else {
			p("��ȸ�� ������ �����ϴ�");
		}
	}

	private static void create(MemoDAO dao) {
		MemoDTO dto = new MemoDTO();
		dto.setName("ȫ�浿");
		dto.setContent("test����");
		dto.setPass("test���");

		if (dao.create(dto)) {
			p("�Է� ����");
		} else {
			p("�Է� ����");
		}
	}

	private static void p(String str) {
		System.out.println(str);
	}

	private static void p(MemoDTO dto) {
		System.out.println("----------------------------");
		System.out.println("��ȣ : " + dto.getMemonum());
		System.out.println("�̸� : " + dto.getName());
		System.out.println("���� : " + dto.getContent());
		System.out.println("��� : " + dto.getPass());
	}

}

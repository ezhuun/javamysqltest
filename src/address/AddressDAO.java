package address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBOpen;

public class AddressDAO {

	public List<AddressDTO> list() {
		List<AddressDTO> list = new ArrayList<AddressDTO>();
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from address order by addressnum desc");

		try {
			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				AddressDTO dto = new AddressDTO();
				dto.setAddressnum(rs.getInt("addressnum"));
				dto.setName(rs.getString("name"));
				dto.setHandphone(rs.getString("handphone"));
				dto.setAddress(rs.getString("address"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return list;
	}

	public boolean delete(int addressnum) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" delete from address where addressnum=? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, addressnum);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return flag;
	}

	public boolean update(AddressDTO dto) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" update address set ");
		sql.append(" name=?, handphone=?, address=? ");
		sql.append(" where addressnum=? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHandphone());
			pstmt.setString(3, dto.getAddress());
			pstmt.setInt(4, dto.getAddressnum());
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return flag;
	}

	public AddressDTO read(int addressnum) {
		AddressDTO dto = null;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from address where addressnum=? ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, addressnum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new AddressDTO();
				dto.setAddressnum(rs.getInt("addressnum"));
				dto.setName(rs.getString("name"));
				dto.setHandphone(rs.getString("handphone"));
				dto.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return dto;
	}

	/**
	 * DB에 한 사람의 데이터를 저장한다
	 * 
	 * @param dto
	 *            저장할 한 사람의 주소
	 * @return true=성공, false=실패
	 */
	public boolean create(AddressDTO dto) {
		boolean flag = false;
		Connection con = DBOpen.open();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();

		sql.append(" insert into address(name, handphone, address) ");
		sql.append(" values(?, ?, ?) ");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHandphone());
			pstmt.setString(3, dto.getAddress());

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}

		return flag;
	}

}

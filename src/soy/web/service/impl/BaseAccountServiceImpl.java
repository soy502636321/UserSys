package soy.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseAccountDAO;
import soy.basic.database.entity.BaseAccount;
import soy.basic.vo.BaseAccountVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.SystemUtil;
import soy.web.service.BaseAccountService;


public class BaseAccountServiceImpl implements BaseAccountService {
	private static final Logger log = LoggerFactory
			.getLogger(BaseAccountServiceImpl.class);
	private static Map<Integer, String> map;
	private BaseAccountDAO baseAccountDAO;

	@Override
	public Map<Integer, String> getMap() {
		if (SystemUtil.isEmpty(map)) {
			map = new HashMap<Integer, String>();
			map.put(0, "");
			List<BaseAccount> list = getBaseAccountDAO().findAll();
			for (BaseAccount baseAccount : list) {
				map.put(baseAccount.getId(), baseAccount.getAccountName());
			}
		}
		return map;
	}

	public BaseAccountDAO getBaseAccountDAO() {
		return baseAccountDAO;
	}

	public void setBaseAccountDAO(BaseAccountDAO baseAccountDAO) {
		this.baseAccountDAO = baseAccountDAO;
	}

	@Override
	public SimplePaginatedList find(SimplePaginatedList paginatedList,
			BaseAccountVO baseAccountVO) {
		paginatedList = getBaseAccountDAO().find(paginatedList, baseAccountVO);
		List<BaseAccount> baseAccounts = paginatedList.getList();
		List vos = new ArrayList();
		if (!SystemUtil.isNull(baseAccounts)) {
			for (BaseAccount baseAccount : baseAccounts) {
				vos.add(new BaseAccountVO(baseAccount));
			}
		}
		paginatedList.setList(vos);
		return paginatedList;
	}

	@Override
	public int delete(Integer[] ids) {
		log.debug("");
		System.out.println("删除步骤1");
		int size = 0;
		if (!SystemUtil.isNull(ids)) {
			for (Integer id : ids) {
				try {
					System.out.println("删除步骤2");
					BaseAccount baseAccount = (BaseAccount) getBaseAccountDAO().findById(id);
					getBaseAccountDAO().delete(baseAccount);
					size++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return size;
	}

}

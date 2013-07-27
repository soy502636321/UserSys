package soy.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.IdClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soy.basic.dao.BaseAccountDAO;
import soy.basic.dao.BaseEducationalDAO;
import soy.basic.dao.BaseOrganDAO;
import soy.basic.dao.SysWorkerDAO;
import soy.basic.database.entity.BaseAccount;
import soy.basic.database.entity.BaseEducational;
import soy.basic.database.entity.BaseOrgan;
import soy.basic.database.entity.SysWorker;
import soy.basic.vo.SysUserVO;
import soy.basic.vo.SysWorkerVO;
import soy.common.displaytag.SimplePaginatedList;
import soy.util.SystemUtil;
import soy.web.service.WorkerService;


public class WorkerServiceImpl implements WorkerService {
	private static final Logger log = LoggerFactory
			.getLogger(WorkerServiceImpl.class);

	private SysWorkerDAO sysWorkerDAO;
	private BaseOrganDAO baseOrganDAO;
	private BaseAccountDAO baseAccountDAO;
	private BaseEducationalDAO baseEducationalDAO;

	@Override
	public SimplePaginatedList find(SimplePaginatedList paginatedList,
			SysWorkerVO workerVO) {
		paginatedList = getSysWorkerDAO().find(paginatedList, workerVO);
		List list = paginatedList.getList();
		List vos = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			vos.add(new SysWorkerVO((SysWorker) list.get(i)));
		}
		paginatedList.setList(vos);
		return paginatedList;
	}

	public SysWorkerDAO getSysWorkerDAO() {
		return sysWorkerDAO;
	}

	public void setSysWorkerDAO(SysWorkerDAO sysWorkerDAO) {
		this.sysWorkerDAO = sysWorkerDAO;
	}

	public BaseOrganDAO getBaseOrganDAO() {
		return baseOrganDAO;
	}

	public void setBaseOrganDAO(BaseOrganDAO baseOrganDAO) {
		this.baseOrganDAO = baseOrganDAO;
	}

	public BaseAccountDAO getBaseAccountDAO() {
		return baseAccountDAO;
	}

	public void setBaseAccountDAO(BaseAccountDAO baseAccountDAO) {
		this.baseAccountDAO = baseAccountDAO;
	}

	public BaseEducationalDAO getBaseEducationalDAO() {
		return baseEducationalDAO;
	}

	public void setBaseEducationalDAO(BaseEducationalDAO baseEducationalDAO) {
		this.baseEducationalDAO = baseEducationalDAO;
	}

	@Override
	public int delete(Integer[] ids) {
		log.debug("");
		int size = 0;
		if (!SystemUtil.isNull(ids)) {
			for (Integer id : ids) {
				try {
					SysWorker sysWorker = (SysWorker) getSysWorkerDAO()
							.findById(id);
					getSysWorkerDAO().delete(sysWorker);
					size++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return size;
	}

	@Override
	public SysWorkerVO save(SysWorkerVO sysWorkerVO, SysUserVO sysUserVO) {
		log.debug("");
		if (sysWorkerVO != null) {
			BaseOrgan baseOrgan = (BaseOrgan) getBaseOrganDAO().findById(
					sysWorkerVO.getBaseOrganId());
			BaseEducational baseEducational = (BaseEducational) getBaseEducationalDAO().findById(sysWorkerVO.getBaseEducationalId());
			BaseAccount baseAccount = (BaseAccount) getBaseAccountDAO().findById(sysWorkerVO.getBaseAccountId());
			String name = sysWorkerVO.getName();
			System.out.println("名字乱码 >>" + name);
			Integer gender = sysWorkerVO.getGenderId();
			Date birthday = sysWorkerVO.getBirthday();
			String idCard = sysWorkerVO.getIdCard();
			String address = sysWorkerVO.getAddress();
			String passport = sysWorkerVO.getPassport();
			Date outDate = sysWorkerVO.getOutDate();
			Date inDate = sysWorkerVO.getInDate();
			Date insureDate = sysWorkerVO.getInsureDate();
			Integer record = sysWorkerVO.getRecordId();
			String remark = sysWorkerVO.getRemark();
			
			SysWorker sysWorker = new SysWorker(baseOrgan, baseEducational,
					sysUserVO.getSysUser(), baseAccount, name, gender, birthday, idCard,
					address, passport, outDate, inDate, insureDate, record,
					remark, new Date());
			try {
				getSysWorkerDAO().save(sysWorker);
				return sysWorkerVO;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public SysWorkerVO findById(Integer id) {
		if (id != null ) {
			SysWorker sysWorker = (SysWorker) getSysWorkerDAO().findById(id);
			if (sysWorker != null) {
				return new SysWorkerVO(sysWorker);
			}
		}
		return null;
	}

}

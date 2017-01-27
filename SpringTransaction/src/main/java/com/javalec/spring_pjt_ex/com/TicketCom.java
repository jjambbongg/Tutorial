package com.javalec.spring_pjt_ex.com;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.spring_pjt_ex.dao.TicketDao;
import com.javalec.spring_pjt_ex.dto.TicketDto;

public class TicketCom implements ITicketCom{

	private TicketDao ticketDao;
	
	private TransactionTemplate transactionTemplate2;
	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}

	@Override
	public void execute(final TicketDto dto) {
		/*dto.setConsumerId("id01");
		ticketDao.buyTicket(dto);
		
		dto.setConsumerId("id01");
		ticketDao.buyTicket(dto);*/
		
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				dto.setConsumerId("id01");
				ticketDao.buyTicket(dto);
				
				dto.setConsumerId("id01");
				ticketDao.buyTicket(dto);
				
			}
		});
		
	}
	

}

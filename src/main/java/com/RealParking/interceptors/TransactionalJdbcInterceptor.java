package com.RealParking.interceptors;

import com.RealParking.configs.MysqlConn;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@TransactionalJdbc
@Interceptor
public class TransactionalJdbcInterceptor {

    @Inject
    @MysqlConn
    private Connection conn;

    @Inject
    private Logger log;

    @AroundInvoke
    public Object transactional(InvocationContext invocation) throws Exception {
        if (conn.getAutoCommit()) {
            conn.setAutoCommit(false);
        }

        try {
            log.info(" ------> Iniciando transacción " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            Object result = invocation.proceed();
            conn.commit();
            log.info(" ------> realizando commit y finalizando transacción " + invocation.getMethod().getName() +
                    " de la clase " + invocation.getMethod().getDeclaringClass());
            return result;
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

}

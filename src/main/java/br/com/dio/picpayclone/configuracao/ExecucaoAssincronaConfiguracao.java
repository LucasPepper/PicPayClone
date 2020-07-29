package br.com.dio.picpayclone.configuracao;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync

// A validação do saldo é feita um pouco depois. Como ela demora um pouco, para não travar a tela do usuário, é feita uma validação assíncrona (background)
// Boa prática: utiliza uma fila (broker) para processar essas transações
// Existem APIs das operadoras de cartão de crédito para Sand Box/Tests para estas transações
public class ExecucaoAssincronaConfiguracao {

	@Bean(name = "asyncExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("AsyncThread-");
		executor.initialize();
		return executor;
	}

//	@Bean
//	public MethodInvokingFactoryBean methodInvokingFactoryBean() {
//		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
//		methodInvokingFactoryBean.setTargetClass(SecurityContextHolder.class);
//		methodInvokingFactoryBean.setTargetMethod("setStrategyName");
//		methodInvokingFactoryBean.setArguments(new Object[] { SecurityContextHolder.MODE_INHERITABLETHREADLOCAL });
//		return methodInvokingFactoryBean;
//	}
	
}

package sisrh.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import sisrh.banco.Banco;
import sisrh.dto.Solicitacao;

@Api
@Path("/solicitacao")
public class SolicitacaoRest {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarSolicitacoes() throws Exception {
		List<Solicitacao> lista = Banco.listarSolicitacoes();		
		GenericEntity<List<Solicitacao>> entity = new GenericEntity<List<Solicitacao>>(lista) {};
		return Response.ok().entity(entity).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterSolicitacao(@PathParam("id") Integer id) throws Exception {
		try {
			Solicitacao solicitacao= Banco.buscarSolicitacaoPorId(id);
			if ( solicitacao != null ) {
				return Response.ok().entity(solicitacao).build();
			}else {
				return Response.status(Status.NOT_FOUND)
						.entity("{ \"mensagem\" : \"Solicita��o nao encontrada!\" }").build();
			}
		}catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("{ \"mensagem\" : \"Falha ao obter solicita��o!\" , \"detalhe\" :  \""+ e.getMessage() +"\"  }").build();
		}
	}
	
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response incluirSolicitacao(Solicitacao solicitacao) {
		try {
			Solicitacao emp = Banco.incluirSolicitacao(solicitacao);
			return Response.ok().entity(emp).build();
		}catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("{ \"mensagem\" : \"Falha na inclusao da solicita��o!\" , \"detalhe\" :  \""+ e.getMessage() +"\"  }").build();
		}		
	}
	
	@PUT	
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarSolicitacao(@PathParam("id") Integer id, Solicitacao solicitacao)  {
		try {			
			if ( Banco.buscarSolicitacaoPorId(id) == null ) {				
				return Response.status(Status.NOT_FOUND)
						.entity("{ \"mensagem\" : \"Solicita��o n�o encontrada!\" }").build();
			}				
			Solicitacao emp = Banco.alterarSolicitacao(id, solicitacao);	
			return Response.ok().entity(emp).build();
		}catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("{ \"mensagem\" : \"Falha na alteracao da solicita��o!\" , \"detalhe\" :  \""+ e.getMessage() +"\"  }").build();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirSolicitacao(@PathParam("id") Integer id) throws Exception {
		try {
			if ( Banco.buscarSolicitacaoPorId(id) == null ) {				
				return Response.status(Status.NOT_FOUND).
						entity("{ \"mensagem\" : \"Solicita��o n�o encontrada!\" }").build();
			}				
			Banco.excluirSolicitacao(id);
			return Response.ok().entity("{ \"mensagem\" : \"Solicitacao com id "+ id + " excluida!\" }").build();	
		}catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).
					entity("{ \"mensagem\" : \"Falha na exclusao da solicita��o!\" , \"detalhe\" :  \""+ e.getMessage() +"\"  }").build();
		}		
	}
}
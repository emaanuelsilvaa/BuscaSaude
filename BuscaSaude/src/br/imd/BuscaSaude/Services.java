package br.imd.BuscaSaude;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

public class Services extends UnicastRemoteObject implements IServices {

	private ArrayList<UnidadeSaude> unidades;
	private int idCount;


	protected Services() throws RemoteException {
		super();
		unidades = new ArrayList<>();
		idCount = 0;
	}

	@Override
	public void cadastrar(UnidadeSaude unidadeSaude) throws RemoteException {
		unidadeSaude.setId(idCount);
		unidades.add(unidadeSaude);
		System.out.println("Nova Unidade Cadastrada: \n" + unidadeSaude.toString() );
		idCount++;
	}

	@Override
	public void atualizar(UnidadeSaude unidadeSaude) throws RemoteException {
		UnidadeSaude unidadeSaudeIterator = null;
		Iterator<UnidadeSaude> inter1 = unidades.iterator();
		
		while (inter1.hasNext()) {
			
			unidadeSaudeIterator = (UnidadeSaude) inter1.next();
			
			
			if(unidadeSaude.getId() == unidadeSaudeIterator.getId() ) {
				int index = unidades.indexOf(unidadeSaudeIterator);
				unidades.set(index, unidadeSaude);
			}
			
			
		}
	}

	@Override
	public void excluir( int id ) throws RemoteException {
		UnidadeSaude unidadeSaudeIterator = null;
		Iterator<UnidadeSaude> inter1 = unidades.iterator();
		
		while (inter1.hasNext()) {
			
			unidadeSaudeIterator = (UnidadeSaude) inter1.next();
			
			
			if( id == unidadeSaudeIterator.getId() ) {
				int index = unidades.indexOf(unidadeSaudeIterator);
				unidades.remove(index);
			}
			
		}
		
	}

	@Override
	public ArrayList<UnidadeSaude> buscar(int criterio, String busca) throws RemoteException {
		
		UnidadeSaude unidadeSaudeIterator = null;
		String EspContentList;
		ArrayList<UnidadeSaude> returnList = new ArrayList<>();
		Iterator<UnidadeSaude> inter1 = unidades.iterator();
		
		
		switch (criterio) {
			case 1:
				while (inter1.hasNext()) {
					
					unidadeSaudeIterator = (UnidadeSaude) inter1.next();
							
					if( unidadeSaudeIterator.getNome() == busca ) {
						returnList.add(unidadeSaudeIterator);
					}		
				}
			break;
			case 2:
				while (inter1.hasNext()) {	
					unidadeSaudeIterator = (UnidadeSaude) inter1.next();
						
					if( unidadeSaudeIterator.getEndereco() == busca ) {
						returnList.add(unidadeSaudeIterator);
					}		
				}
			break;
			case 3:
				while (inter1.hasNext()) {	
					unidadeSaudeIterator = (UnidadeSaude) inter1.next();
						
					if( unidadeSaudeIterator.getBairro() == busca ) {
						returnList.add(unidadeSaudeIterator);
					}		
				}
			break;
			case 4:
				while (inter1.hasNext()) {	
					unidadeSaudeIterator = (UnidadeSaude) inter1.next();
					
					ArrayList<String> listaEspecialidades = unidadeSaudeIterator.getEspecialidades();
					
					Iterator<String> interListaEspecialidades = listaEspecialidades.iterator();
					while (interListaEspecialidades.hasNext()) {
						EspContentList = interListaEspecialidades.next();
						
						if(EspContentList.equals(busca)) {
							returnList.add(unidadeSaudeIterator);
							break;
						}
						
					}		
				}
			break;
			default:
			
			
		}
		
		return returnList;		
		
	}
	
	public ArrayList<UnidadeSaude> getUnidades() throws RemoteException {
		return this.unidades;
	}

}

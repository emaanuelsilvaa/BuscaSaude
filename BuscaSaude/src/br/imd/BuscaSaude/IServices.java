package br.imd.BuscaSaude;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServices extends Remote {

	public void cadastrar(UnidadeSaude unidadeSaude ) throws RemoteException;
	
	public void atualizar(UnidadeSaude unidadeSaude) throws RemoteException;
	
	public void excluir( int id) throws RemoteException;

	public ArrayList<UnidadeSaude> buscar(int criterio, String busca) throws RemoteException;
	
	public ArrayList<UnidadeSaude> getUnidades() throws RemoteException;
	
	
}



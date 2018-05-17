﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using DAO;
using Oracle.ManagedDataAccess.Client;
namespace APPHostal.templates
{
    /// <summary>
    /// Lógica de interacción para MantenedorUsuarios.xaml
    /// </summary>
    public partial class MantenedorUsuarios : Page
    {
        public MantenedorUsuarios()
        {
            InitializeComponent();
            
        }

        private void btnAgregar_Click(object sender, RoutedEventArgs e)
        {
                USUARIO usuario = new USUARIO();
                usuario.IDUSUARIO = 2;
                usuario.NOMBRE_USUARIO = txNombre.Text;
                usuario.CONTRASENIA = txContrasena.Text;
                usuario.TIPO_USUARIO_ID = 1;
                   
                AddUsuario(usuario);
        }

        public void AddUsuario(USUARIO usu)
            
        {
            using (EntitiesHostal con = new EntitiesHostal())
            {
                con.USUARIO.Add(usu);
                con.SaveChanges();
            }
            LimpiarCampos();
            lbMsg1.Content = "Usuario Ingresado...";
        }
        

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            LimpiarCampos();
        }

        private void dgManteneUsuario_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }

        private void LimpiarCampos()
        {
            txNombre.Text = "";
            txContrasena.Text = "";
            txTipoUsuario.Text = "";

            btnAgregar.IsEnabled = true;
            btnActualizar.IsEnabled = false;    
        }
    }
}

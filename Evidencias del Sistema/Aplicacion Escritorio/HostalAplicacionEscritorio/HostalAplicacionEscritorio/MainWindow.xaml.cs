using System;
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
using System.Data;
using Oracle.ManagedDataAccess.Client;
using Oracle.ManagedDataAccess.Types;
using System.Configuration;

namespace HostalAplicacionEscritorio
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        OracleConnection con = null;
        public MainWindow()
        {
            this.setConnection();
            InitializeComponent();
        }

        private void updateDataGrid()
        {
            OracleCommand cmd = con.CreateCommand();
            cmd.CommandText = "SELECT ID,NOMBRE_USUARIO,CONTRASENIA,TIPO_USUARIO_ID from USUARIO";
            cmd.CommandType = CommandType.Text;
            OracleDataReader dr = cmd.ExecuteReader();
            DataTable dt = new DataTable();
            dt.Load(dr);
            MydataGrid.ItemsSource = dt.DefaultView;
            dr.Close();
        }

        private void setConnection()
        {
            String connectionString = ConfigurationManager.ConnectionStrings["HostalConnection"].ConnectionString;
            con = new OracleConnection(connectionString);
            try
            {
                con.Open();
            }
            catch (Exception exp) { }
        }
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            this.updateDataGrid();
        }

        private void Window_Closed(object sender, EventArgs e)
        {
            con.Close();
        }

        private void btnAgregar_Click(object sender, RoutedEventArgs e)
        {
            String sql = "INSERT INTO USUARIO(ID,NOMBRE_USUARIO,CONTRASENIA,TIPO_USUARIO_ID) " +
                "VALUES(:ID, :NOMBRE, :CONTRASENIA, :TIPO_USUARIO_ID)";
            this.CUD(sql, 0);
            btnAgregar.IsEnabled = false;
            btnActualizar.IsEnabled = true;
            btnEliminar.IsEnabled = true;
            this.LimpiarCampos();
        }

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {
            string sql = "UPDATE TABLE USUARIO SET " +
                "NOMBRE_USUARIO = :NOMBRE_US, " +
                "CONTRASENIA = :CONTRASENA, " +
                "TIPO_USUARIO_ID = :USUARIO_ID " +
                "WHERE ID=:ID";
            this.CUD(sql, 1);
            this.LimpiarCampos();
        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            String sql = "DELETE FROM USUARIO " +
               "WHERE ID = :ID";
            this.CUD(sql, 2);
            this.LimpiarCampos();
        }
        private void LimpiarCampos()
        {
            txId.Text = "";
            txNombre.Text = "";
            txContrasena.Text = "";
            txTipoUsuario.Text = "";

            btnAgregar.IsEnabled = true;
            btnActualizar.IsEnabled = false;
            btnEliminar.IsEnabled = false;
        }
        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            this.LimpiarCampos();
        }
        private void CUD(String sql_stmt, int state)
        {
            String msg = "";
            OracleCommand cmd = con.CreateCommand();
            cmd.CommandText = sql_stmt;
            cmd.CommandType = CommandType.Text;
            switch (state)
            {
                case 0:
                    msg = "Registro de Usuario Ingresado!";
                    cmd.Parameters.Add("ID", OracleDbType.Int32, 10).Value = Int32.Parse(txId.Text);
                    cmd.Parameters.Add("NOMBRE_USUARIO", OracleDbType.Varchar2, 10).Value = txNombre.Text;
                    cmd.Parameters.Add("CONTRASENIA", OracleDbType.Varchar2, 10).Value = txContrasena.Text;
                    cmd.Parameters.Add("TIPO_USUARIO_ID", OracleDbType.Int32, 10).Value = Int32.Parse(txTipoUsuario.Text);
                    break;
                case 1:
                    msg = "Registro de Usuario Actualizado!";
                    cmd.Parameters.Add("NOMBRE_US", OracleDbType.Varchar2, 10).Value = txNombre.Text;
                    cmd.Parameters.Add("CONTRASENA", OracleDbType.Varchar2, 10).Value = txContrasena.Text; 
                    cmd.Parameters.Add("USUARIO_ID", OracleDbType.Int32, 38).Value = Int32.Parse(txTipoUsuario.Text);
                    cmd.Parameters.Add("ID", OracleDbType.Int32, 10).Value = Int32.Parse(txId.Text);
                    break;

                case 2:
                    msg = "Registro de Usuario Eliminado!";
                    cmd.Parameters.Add("ID", OracleDbType.Int32, 6).Value = Int32.Parse(txId.Text);
                    break;
            }

            try
            {
                int n = cmd.ExecuteNonQuery();
                if (n > 0)
                {
                    MessageBox.Show(msg);
                    this.updateDataGrid();
                }
            }
            catch (Exception expe) {
                MessageBox.Show("Error");
            }
        }

        private void MydataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            DataGrid dg = sender as DataGrid;
            DataRowView dr = dg.SelectedItem as DataRowView;
            if (dr != null)
            {
                txId.Text = dr["ID"].ToString();
                txNombre.Text = dr["NOMBRE_USUARIO"].ToString();
                txContrasena.Text = dr["CONTRASENIA"].ToString();
                txTipoUsuario.Text = dr["TIPO_USUARIO_ID"].ToString();
                btnAgregar.IsEnabled = false;
                btnActualizar.IsEnabled = true;
                btnEliminar.IsEnabled = true;

            }
        }
    }
}

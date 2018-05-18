using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Biblioteca
{
    public class Tipo_Usuario
    {
        public decimal IDTIPO_USUARIO { get; set; }
        public string DESCRIPCION { get; set; }

        public Tipo_Usuario(decimal iDTIPO_USUARIO, string dESCRIPCION)
        {
            IDTIPO_USUARIO = iDTIPO_USUARIO;
            DESCRIPCION = dESCRIPCION;
        }

        public Tipo_Usuario()
        {
            this.Init();
        }
        private void Init()
        {

        }
    }
}

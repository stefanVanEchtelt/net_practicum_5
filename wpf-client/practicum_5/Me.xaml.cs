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
using System.Windows.Shapes;

namespace practicum_5
{
    /// <summary>
    /// Interaction logic for Me.xaml
    /// </summary>
    public partial class Me : Window
    {
        public Me()
        {
            InitializeComponent();
            CustomerServiceReference.CustomerServiceClient customerServiceProxy = new CustomerServiceReference.CustomerServiceClient();
            int customerId = Int16.Parse(Application.Current.Resources["CUSTOMER_ID"].ToString());
            CurrentSaldo.Content = "Saldo : \u20AC " + customerServiceProxy.Find(customerId).Balance;
        }
        
        private void To_Buy(object sender, RoutedEventArgs e)
        {
            Buy BuyWindow = new Buy();
            BuyWindow.Show();

            this.Close();
        }
        private void To_Bought_Products(object sender, RoutedEventArgs e)
        {
            BoughtProducts BoughtProductsWindow = new BoughtProducts();
            BoughtProductsWindow.Show();

            this.Close();
        }
    }
}

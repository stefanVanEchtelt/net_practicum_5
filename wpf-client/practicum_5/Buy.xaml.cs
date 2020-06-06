﻿using practicum_5.OrderServiceReference;
using practicum_5.ProductServiceReference;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
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
    /// Interaction logic for Buy.xaml
    /// </summary>
    public partial class Buy : Window
    {
        public Buy()
        {
            InitializeComponent();
            this.LoadProducts();
        }

        private void LoadProducts()
        {
            ProductBox.Items.Clear();
            ProductServiceReference.ProductServiceClient ProductServiceProxy = new ProductServiceReference.ProductServiceClient();
            Product[] products = ProductServiceProxy.All();

            foreach (Product product in products)
            {
                ListBoxItem Item = new ListBoxItem
                {
                    Content = product.Name + ": \u20AC" + Math.Truncate(product.Price * 100) / 100 + " Vooraad: " + product.Stock,
                    DataContext = product.Id
                };

                ProductBox.Items.Add(Item);
            }
        } 

        private void AddToInventory(object sender, RoutedEventArgs e)
        {
            if (ProductBox.SelectedItem != null)
            {
                ListBoxItem selectedItem = (ListBoxItem)ProductBox.SelectedItem;

                ProductServiceReference.ProductServiceClient ProductServiceProxy = new ProductServiceReference.ProductServiceClient();
                Product product = ProductServiceProxy.Find(int.Parse(selectedItem.DataContext.ToString()));

                foreach (ListBoxItem item in InventoryBox.Items)
                {
                    if (int.Parse(item.DataContext.ToString()) == product.Id)
                    {
                        item.Content = product.Name + ", " + (int.Parse(item.Content.ToString().Split(',').Last().Trim()) + 1);
                    }
                }

                if (InventoryBox.Items.Cast<ListBoxItem>().Where(item => int.Parse(item.DataContext.ToString()) == product.Id).Count() <= 0)
                {
                    ListBoxItem Item = new ListBoxItem
                    {
                        Content = product.Name + ", 1",
                        DataContext = product.Id
                    };

                    InventoryBox.Items.Add(Item);
                }
            }
        }

        private void RemoveFromInventory(object sender, RoutedEventArgs e)
        {
            if (ProductBox.SelectedItem != null)
            {
                ListBoxItem selectedItem = (ListBoxItem)InventoryBox.SelectedItem;

                if (int.Parse(selectedItem.Content.ToString().Split(',').Last().Trim()) <= 1)
                {
                    InventoryBox.Items.Remove(selectedItem);
                } else
                {
                    ProductServiceReference.ProductServiceClient ProductServiceProxy = new ProductServiceReference.ProductServiceClient();
                    Product product = ProductServiceProxy.Find(int.Parse(selectedItem.DataContext.ToString()));
                    selectedItem.Content = product.Name + ", " + (int.Parse(selectedItem.Content.ToString().Split(',').Last().Trim()) - 1);
                }
            }
        }

        private void Click_Buy_Button(object sender, RoutedEventArgs e)
        {
            OrderServiceReference.OrderServiceClient OrderServiceProxy = new OrderServiceReference.OrderServiceClient();

            // TODO get current customer ID
            // TODO Handel error messages
            // TODO store id?

            List<BuyingProduct> BuyingProducts = (
                    from bp in InventoryBox.Items.Cast<ListBoxItem>()
                    select new BuyingProduct
                    {
                        Id = int.Parse(bp.DataContext.ToString()),
                        Amount = int.Parse(bp.Content.ToString().Split(',').Last().Trim())
                    }
                ).ToList();

            OrderServiceProxy.Order(1, 1, BuyingProducts.ToArray());

            InventoryBox.Items.Clear();
            this.LoadProducts();

            MessageBox.Show("U order is ingeschoten.");
        }

        private void Click_Refresh_Button(object sender, RoutedEventArgs e)
        {
            this.LoadProducts();
        }

        private void To_Me(object sender, RoutedEventArgs e)
        {
            Me MeWindow = new Me();
            MeWindow.Show();
            this.Close();
        }
    }
}

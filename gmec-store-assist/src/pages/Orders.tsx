import { useState } from "react";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { Package, Clock, CheckCircle, XCircle, Eye, Download } from "lucide-react";
import Header from "@/components/Header";

const Orders = () => {
  const [orders] = useState([
    {
      id: "ORD-2025-001",
      date: "2025-01-05",
      status: "Delivered",
      total: 1175,
      items: [
        { name: "Engineering Lab Coat", quantity: 1, price: 450 },
        { name: "Data Structures & Algorithms", quantity: 1, price: 680 }
      ],
      deliveryDate: "2025-01-07",
      paymentMethod: "Online Payment"
    },
    {
      id: "ORD-2025-002",
      date: "2025-01-08",
      status: "Processing",
      total: 185,
      items: [
        { name: "Graph Paper Notebook", quantity: 3, price: 45 },
        { name: "College ID Card Holder", quantity: 2, price: 25 }
      ],
      estimatedDelivery: "2025-01-12",
      paymentMethod: "Online Payment"
    },
    {
      id: "ORD-2025-003",
      date: "2025-01-10",
      status: "Pending Payment",
      total: 320,
      items: [
        { name: "College Uniform - Shirt", quantity: 1, price: 320 }
      ],
      paymentMethod: "Pending"
    },
    {
      id: "ORD-2024-156",
      date: "2024-12-20",
      status: "Cancelled",
      total: 1200,
      items: [
        { name: "Scientific Calculator", quantity: 1, price: 1200 }
      ],
      cancelReason: "Out of stock",
      paymentMethod: "Refunded"
    }
  ]);

  const getStatusIcon = (status: string) => {
    switch (status) {
      case "Delivered": return <CheckCircle className="h-4 w-4" />;
      case "Processing": return <Clock className="h-4 w-4" />;
      case "Pending Payment": return <XCircle className="h-4 w-4" />;
      case "Cancelled": return <XCircle className="h-4 w-4" />;
      default: return <Package className="h-4 w-4" />;
    }
  };

  const getStatusColor = (status: string) => {
    switch (status) {
      case "Delivered": return "bg-green-100 text-green-800";
      case "Processing": return "bg-blue-100 text-blue-800";
      case "Pending Payment": return "bg-yellow-100 text-yellow-800";
      case "Cancelled": return "bg-red-100 text-red-800";
      default: return "bg-gray-100 text-gray-800";
    }
  };

  const filterOrdersByStatus = (status: string) => {
    if (status === "all") return orders;
    return orders.filter(order => order.status === status);
  };

  const OrderCard = ({ order }: { order: any }) => (
    <Card className="shadow-card hover:shadow-feature transition-all duration-300">
      <CardHeader className="pb-4">
        <div className="flex items-center justify-between">
          <div>
            <CardTitle className="text-lg">Order #{order.id}</CardTitle>
            <CardDescription>Placed on {new Date(order.date).toLocaleDateString()}</CardDescription>
          </div>
          <Badge className={`${getStatusColor(order.status)} flex items-center space-x-1`}>
            {getStatusIcon(order.status)}
            <span>{order.status}</span>
          </Badge>
        </div>
      </CardHeader>
      <CardContent className="space-y-4">
        {/* Order Items */}
        <div className="space-y-2">
          <h4 className="font-medium text-sm">Items Ordered:</h4>
          {order.items.map((item: any, index: number) => (
            <div key={index} className="flex justify-between items-center text-sm bg-muted/50 p-2 rounded">
              <span>{item.name} × {item.quantity}</span>
              <span className="font-medium">₹{item.price * item.quantity}</span>
            </div>
          ))}
        </div>

        {/* Order Details */}
        <div className="flex justify-between items-center text-sm">
          <span>Total Amount:</span>
          <span className="font-bold text-lg text-primary">₹{order.total}</span>
        </div>

        <div className="flex justify-between items-center text-sm">
          <span>Payment Method:</span>
          <span>{order.paymentMethod}</span>
        </div>

        {order.deliveryDate && (
          <div className="flex justify-between items-center text-sm">
            <span>Delivered on:</span>
            <span className="text-green-600 font-medium">
              {new Date(order.deliveryDate).toLocaleDateString()}
            </span>
          </div>
        )}

        {order.estimatedDelivery && (
          <div className="flex justify-between items-center text-sm">
            <span>Estimated Delivery:</span>
            <span className="text-blue-600 font-medium">
              {new Date(order.estimatedDelivery).toLocaleDateString()}
            </span>
          </div>
        )}

        {order.cancelReason && (
          <div className="text-sm">
            <span className="text-red-600">Cancellation Reason: </span>
            <span>{order.cancelReason}</span>
          </div>
        )}

        {/* Actions */}
        <div className="flex space-x-2 pt-2">
          <Button variant="outline" size="sm" className="flex-1">
            <Eye className="h-4 w-4 mr-2" />
            View Details
          </Button>
          {order.status === "Delivered" && (
            <Button variant="outline" size="sm" className="flex-1">
              <Download className="h-4 w-4 mr-2" />
              Download Invoice
            </Button>
          )}
          {order.status === "Pending Payment" && (
            <Button size="sm" className="flex-1 bg-hero-gradient hover:opacity-90">
              Complete Payment
            </Button>
          )}
        </div>
      </CardContent>
    </Card>
  );

  return (
    <div className="min-h-screen bg-background">
      <Header />
      
      <main className="container px-4 py-8">
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-foreground mb-2">My Orders</h1>
          <p className="text-muted-foreground">Track and manage your purchase history</p>
        </div>

        <Tabs defaultValue="all" className="space-y-6">
          <TabsList className="grid w-full grid-cols-5">
            <TabsTrigger value="all">All Orders</TabsTrigger>
            <TabsTrigger value="Processing">Processing</TabsTrigger>
            <TabsTrigger value="Delivered">Delivered</TabsTrigger>
            <TabsTrigger value="Pending Payment">Pending</TabsTrigger>
            <TabsTrigger value="Cancelled">Cancelled</TabsTrigger>
          </TabsList>

          <TabsContent value="all" className="space-y-4">
            {orders.map((order) => (
              <OrderCard key={order.id} order={order} />
            ))}
          </TabsContent>

          <TabsContent value="Processing" className="space-y-4">
            {filterOrdersByStatus("Processing").map((order) => (
              <OrderCard key={order.id} order={order} />
            ))}
          </TabsContent>

          <TabsContent value="Delivered" className="space-y-4">
            {filterOrdersByStatus("Delivered").map((order) => (
              <OrderCard key={order.id} order={order} />
            ))}
          </TabsContent>

          <TabsContent value="Pending Payment" className="space-y-4">
            {filterOrdersByStatus("Pending Payment").map((order) => (
              <OrderCard key={order.id} order={order} />
            ))}
          </TabsContent>

          <TabsContent value="Cancelled" className="space-y-4">
            {filterOrdersByStatus("Cancelled").map((order) => (
              <OrderCard key={order.id} order={order} />
            ))}
          </TabsContent>
        </Tabs>

        {/* Order Statistics */}
        <div className="mt-12 bg-feature-gradient rounded-lg p-8">
          <div className="text-center mb-8">
            <h2 className="text-2xl font-bold text-foreground mb-2">Order Statistics</h2>
            <p className="text-muted-foreground">Your shopping summary</p>
          </div>
          <div className="grid grid-cols-2 md:grid-cols-4 gap-6">
            <div className="text-center">
              <div className="text-3xl font-bold text-primary mb-1">{orders.length}</div>
              <div className="text-sm text-muted-foreground">Total Orders</div>
            </div>
            <div className="text-center">
              <div className="text-3xl font-bold text-primary mb-1">
                {orders.filter(o => o.status === "Delivered").length}
              </div>
              <div className="text-sm text-muted-foreground">Delivered</div>
            </div>
            <div className="text-center">
              <div className="text-3xl font-bold text-primary mb-1">
                ₹{orders.filter(o => o.status === "Delivered").reduce((sum, o) => sum + o.total, 0)}
              </div>
              <div className="text-sm text-muted-foreground">Total Spent</div>
            </div>
            <div className="text-center">
              <div className="text-3xl font-bold text-primary mb-1">
                {orders.filter(o => o.status === "Processing").length}
              </div>
              <div className="text-sm text-muted-foreground">In Progress</div>
            </div>
          </div>
        </div>
      </main>
    </div>
  );
};

export default Orders;
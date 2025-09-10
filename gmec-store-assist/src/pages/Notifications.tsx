import { useState } from "react";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { Bell, Package, AlertTriangle, CheckCircle, X, Settings } from "lucide-react";
import Header from "@/components/Header";
import { useToast } from "@/hooks/use-toast";

const Notifications = () => {
  const { toast } = useToast();
  const [notifications, setNotifications] = useState([
    {
      id: 1,
      type: "restock",
      title: "Item Back in Stock",
      message: "Data Structures & Algorithms is now available for purchase",
      timestamp: "2025-01-10T10:30:00Z",
      read: false,
      priority: "high"
    },
    {
      id: 2,
      type: "order",
      title: "Order Confirmed",
      message: "Your order #ORD-2025-002 has been confirmed and is being processed",
      timestamp: "2025-01-08T14:15:00Z",
      read: false,
      priority: "medium"
    },
    {
      id: 3,
      type: "stock_alert",
      title: "Low Stock Alert",
      message: "College Uniform - Shirt is running low (5 units remaining)",
      timestamp: "2025-01-07T09:00:00Z",
      read: true,
      priority: "high"
    },
    {
      id: 4,
      type: "delivery",
      title: "Order Delivered",
      message: "Your order #ORD-2025-001 has been successfully delivered",
      timestamp: "2025-01-07T16:45:00Z",
      read: true,
      priority: "low"
    },
    {
      id: 5,
      type: "promotion",
      title: "Special Offer",
      message: "Get 10% off on all lab equipment this week!",
      timestamp: "2025-01-05T08:00:00Z",
      read: true,
      priority: "medium"
    }
  ]);

  const getNotificationIcon = (type: string) => {
    switch (type) {
      case "restock": return <Package className="h-5 w-5 text-green-600" />;
      case "order": return <CheckCircle className="h-5 w-5 text-blue-600" />;
      case "stock_alert": return <AlertTriangle className="h-5 w-5 text-yellow-600" />;
      case "delivery": return <CheckCircle className="h-5 w-5 text-green-600" />;
      case "promotion": return <Bell className="h-5 w-5 text-purple-600" />;
      default: return <Bell className="h-5 w-5 text-gray-600" />;
    }
  };

  const getPriorityColor = (priority: string) => {
    switch (priority) {
      case "high": return "bg-red-100 text-red-800";
      case "medium": return "bg-yellow-100 text-yellow-800";
      case "low": return "bg-green-100 text-green-800";
      default: return "bg-gray-100 text-gray-800";
    }
  };

  const markAsRead = (id: number) => {
    setNotifications(notifications.map(notif => 
      notif.id === id ? { ...notif, read: true } : notif
    ));
  };

  const deleteNotification = (id: number) => {
    setNotifications(notifications.filter(notif => notif.id !== id));
    toast({
      title: "Notification deleted",
      description: "The notification has been removed",
    });
  };

  const markAllAsRead = () => {
    setNotifications(notifications.map(notif => ({ ...notif, read: true })));
    toast({
      title: "All notifications marked as read",
      description: "You're all caught up!",
    });
  };

  const filterNotifications = (type: string) => {
    if (type === "all") return notifications;
    if (type === "unread") return notifications.filter(n => !n.read);
    return notifications.filter(n => n.type === type);
  };

  const formatTimestamp = (timestamp: string) => {
    const date = new Date(timestamp);
    const now = new Date();
    const diffInHours = Math.floor((now.getTime() - date.getTime()) / (1000 * 60 * 60));
    
    if (diffInHours < 1) return "Just now";
    if (diffInHours < 24) return `${diffInHours}h ago`;
    return date.toLocaleDateString();
  };

  const NotificationCard = ({ notification }: { notification: any }) => (
    <Card className={`shadow-card hover:shadow-feature transition-all duration-300 ${
      !notification.read ? "bg-primary/5 border-primary/20" : ""
    }`}>
      <CardContent className="p-4">
        <div className="flex items-start space-x-4">
          <div className="flex-shrink-0 mt-1">
            {getNotificationIcon(notification.type)}
          </div>
          <div className="flex-1 min-w-0">
            <div className="flex items-center justify-between mb-2">
              <h3 className={`font-semibold ${!notification.read ? "text-primary" : "text-foreground"}`}>
                {notification.title}
              </h3>
              <div className="flex items-center space-x-2">
                <Badge className={getPriorityColor(notification.priority)} variant="secondary">
                  {notification.priority}
                </Badge>
                {!notification.read && (
                  <div className="h-2 w-2 bg-primary rounded-full"></div>
                )}
              </div>
            </div>
            <p className="text-sm text-muted-foreground mb-3">{notification.message}</p>
            <div className="flex items-center justify-between">
              <span className="text-xs text-muted-foreground">
                {formatTimestamp(notification.timestamp)}
              </span>
              <div className="flex space-x-2">
                {!notification.read && (
                  <Button 
                    variant="outline" 
                    size="sm"
                    onClick={() => markAsRead(notification.id)}
                  >
                    Mark as Read
                  </Button>
                )}
                <Button 
                  variant="ghost" 
                  size="sm"
                  onClick={() => deleteNotification(notification.id)}
                >
                  <X className="h-4 w-4" />
                </Button>
              </div>
            </div>
          </div>
        </div>
      </CardContent>
    </Card>
  );

  const unreadCount = notifications.filter(n => !n.read).length;

  return (
    <div className="min-h-screen bg-background">
      <Header />
      
      <main className="container px-4 py-8">
        <div className="mb-8">
          <div className="flex items-center justify-between">
            <div>
              <h1 className="text-3xl font-bold text-foreground mb-2">Notifications</h1>
              <p className="text-muted-foreground">
                Stay updated with your orders and store updates
                {unreadCount > 0 && (
                  <Badge className="ml-2 bg-primary text-primary-foreground">
                    {unreadCount} unread
                  </Badge>
                )}
              </p>
            </div>
            {unreadCount > 0 && (
              <Button variant="outline" onClick={markAllAsRead}>
                Mark All as Read
              </Button>
            )}
          </div>
        </div>

        <Tabs defaultValue="all" className="space-y-6">
          <TabsList className="grid w-full grid-cols-6">
            <TabsTrigger value="all">All</TabsTrigger>
            <TabsTrigger value="unread">Unread</TabsTrigger>
            <TabsTrigger value="restock">Restocks</TabsTrigger>
            <TabsTrigger value="order">Orders</TabsTrigger>
            <TabsTrigger value="stock_alert">Alerts</TabsTrigger>
            <TabsTrigger value="promotion">Offers</TabsTrigger>
          </TabsList>

          {["all", "unread", "restock", "order", "stock_alert", "promotion"].map((tab) => (
            <TabsContent key={tab} value={tab} className="space-y-4">
              {filterNotifications(tab).length === 0 ? (
                <Card className="shadow-card">
                  <CardContent className="text-center py-12">
                    <Bell className="h-16 w-16 text-muted-foreground mx-auto mb-4" />
                    <h3 className="text-xl font-semibold text-foreground mb-2">No notifications</h3>
                    <p className="text-muted-foreground">
                      {tab === "unread" ? "You're all caught up!" : `No ${tab} notifications found`}
                    </p>
                  </CardContent>
                </Card>
              ) : (
                filterNotifications(tab).map((notification) => (
                  <NotificationCard key={notification.id} notification={notification} />
                ))
              )}
            </TabsContent>
          ))}
        </Tabs>

        {/* Notification Settings */}
        <Card className="mt-8 shadow-card">
          <CardHeader>
            <CardTitle className="flex items-center space-x-2">
              <Settings className="h-5 w-5" />
              <span>Notification Preferences</span>
            </CardTitle>
            <CardDescription>Customize when and how you receive notifications</CardDescription>
          </CardHeader>
          <CardContent>
            <div className="space-y-4">
              <div className="flex items-center justify-between">
                <div>
                  <h4 className="font-medium">Restock Notifications</h4>
                  <p className="text-sm text-muted-foreground">Get notified when out-of-stock items are available</p>
                </div>
                <Button variant="outline" size="sm">Enabled</Button>
              </div>
              <div className="flex items-center justify-between">
                <div>
                  <h4 className="font-medium">Order Updates</h4>
                  <p className="text-sm text-muted-foreground">Receive updates about your orders</p>
                </div>
                <Button variant="outline" size="sm">Enabled</Button>
              </div>
              <div className="flex items-center justify-between">
                <div>
                  <h4 className="font-medium">Promotional Offers</h4>
                  <p className="text-sm text-muted-foreground">Get notified about special deals and offers</p>
                </div>
                <Button variant="outline" size="sm">Enabled</Button>
              </div>
              <div className="flex items-center justify-between">
                <div>
                  <h4 className="font-medium">Low Stock Alerts</h4>
                  <p className="text-sm text-muted-foreground">For store managers: alerts when items are running low</p>
                </div>
                <Button variant="outline" size="sm">Enabled</Button>
              </div>
            </div>
          </CardContent>
        </Card>
      </main>
    </div>
  );
};

export default Notifications;
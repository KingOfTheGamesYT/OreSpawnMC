/*     */ package danger.orespawn;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityCannonFodder
/*     */   extends EntityTameable
/*     */ {
/*  26 */   String name_one = null;
/*  27 */   String name_two = null;
/*  28 */   private int is_activated = 0;
/*  29 */   private int hat_color = 0;
/*  30 */   private int syncer = 0;
/*  31 */   private int px = 0;
/*  32 */   private int pz = 0;
/*  33 */   private int py = 0;
/*  34 */   private GenericTargetSorter LocalTargetSorter = null;
/*     */   
/*     */   public EntityCannonFodder(World par1World) {
/*  37 */     super(par1World);
/*  38 */     this.LocalTargetSorter = new GenericTargetSorter((Entity)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  43 */     super.applyEntityAttributes();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void entityInit() {
/*  49 */     super.entityInit();
/*  50 */     this.dataWatcher.addObject(20, Integer.valueOf(0));
/*  51 */     this.dataWatcher.addObject(21, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/*  56 */     super.onUpdate();
/*  57 */     this.syncer++;
/*  58 */     if (this.syncer > 5) {
/*  59 */       if (this.worldObj.isRemote) {
/*  60 */         this.is_activated = this.dataWatcher.getWatchableObjectInt(20);
/*  61 */         this.hat_color = this.dataWatcher.getWatchableObjectInt(21);
/*     */       } else {
/*     */         
/*  64 */         this.dataWatcher.updateObject(20, Integer.valueOf(this.is_activated));
/*  65 */         this.dataWatcher.updateObject(21, Integer.valueOf(this.hat_color));
/*     */       } 
/*     */       
/*  68 */       this.syncer = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  74 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*     */     
/*  76 */     if (var2 != null)
/*     */     {
/*  78 */       if (var2.stackSize <= 0) {
/*     */         
/*  80 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  81 */         var2 = null;
/*     */       } 
/*     */     }
/*     */     
/*  85 */     if (super.interact(par1EntityPlayer)) {
/*  86 */       return true;
/*     */     }
/*     */     
/*  89 */     if (this.name_one != null && isTamed()) {
/*  90 */       if (this.name_one.equals(par1EntityPlayer.getUniqueID().toString())) {
/*  91 */         if (this.name_two == null)
/*     */         {
/*     */           
/*  94 */           this.name_two = this.name_one;
/*  95 */           this.name_one = par1EntityPlayer.getUniqueID().toString();
/*     */           
/*  97 */           func_152115_b(this.name_one);
/*  98 */           this.is_activated = 2;
/*     */         }
/*     */       
/* 101 */       } else if (this.name_two != null) {
/* 102 */         if (this.name_two.equals(par1EntityPlayer.getUniqueID().toString())) {
/*     */           
/* 104 */           this.name_two = this.name_one;
/* 105 */           this.name_one = par1EntityPlayer.getUniqueID().toString();
/* 106 */           func_152115_b(this.name_one);
/* 107 */           this.is_activated = 2;
/*     */         } else {
/*     */           
/* 110 */           return true;
/*     */         } 
/*     */       } else {
/* 113 */         this.name_two = this.name_one;
/* 114 */         this.name_one = par1EntityPlayer.getUniqueID().toString();
/* 115 */         func_152115_b(this.name_one);
/* 116 */         this.is_activated = 2;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 121 */     if (var2 != null && var2.getItem() == Items.carrot && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/* 122 */       this.hat_color = 1;
/*     */       
/* 124 */       if (this.name_one == null) this.name_one = par1EntityPlayer.getUniqueID().toString(); 
/* 125 */       if (this.is_activated == 0) this.is_activated = 1; 
/* 126 */       setTamed(true);
/* 127 */       func_152115_b(this.name_one);
/* 128 */       playTameEffect(true);
/* 129 */       heal(getMaxHealth() - getHealth());
/* 130 */       enablePersistence();
/* 131 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 133 */         var2.stackSize--;
/* 134 */         if (var2.stackSize <= 0)
/*     */         {
/* 136 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 139 */       return true;
/* 140 */     }  if (var2 != null && var2.getItem() == Items.potato && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/* 141 */       this.hat_color = 3;
/*     */       
/* 143 */       if (this.name_one == null) this.name_one = par1EntityPlayer.getUniqueID().toString(); 
/* 144 */       if (this.is_activated == 0) this.is_activated = 1; 
/* 145 */       setTamed(true);
/* 146 */       func_152115_b(this.name_one);
/* 147 */       playTameEffect(true);
/* 148 */       heal(getMaxHealth() - getHealth());
/* 149 */       enablePersistence();
/* 150 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 152 */         var2.stackSize--;
/* 153 */         if (var2.stackSize <= 0)
/*     */         {
/* 155 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 158 */       return true;
/* 159 */     }  if (var2 != null && var2.getItem() == OreSpawnMain.MyQuinoa && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/* 160 */       this.hat_color = 2;
/*     */       
/* 162 */       if (this.name_one == null) this.name_one = par1EntityPlayer.getUniqueID().toString(); 
/* 163 */       if (this.is_activated == 0) this.is_activated = 1; 
/* 164 */       setTamed(true);
/* 165 */       func_152115_b(this.name_one);
/* 166 */       playTameEffect(true);
/* 167 */       heal(getMaxHealth() - getHealth());
/* 168 */       enablePersistence();
/* 169 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 171 */         var2.stackSize--;
/* 172 */         if (var2.stackSize <= 0)
/*     */         {
/* 174 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 177 */       return true;
/* 178 */     }  if (var2 != null && this.is_activated == 2 && var2.getItem() == OreSpawnMain.MyCornCob && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*     */       
/* 180 */       String myname = "Ostrich";
/* 181 */       if (this instanceof Lizard) myname = "Lizard"; 
/* 182 */       if (this instanceof Chipmunk) myname = "Chipmunk"; 
/* 183 */       if (this instanceof VelocityRaptor) myname = "Velocity Raptor"; 
/* 184 */       if (!this.worldObj.isRemote) {
/* 185 */         Entity newent = spawnCreature(this.worldObj, myname, this.posX + this.worldObj.rand.nextFloat(), this.posY + 0.01D, this.posZ + this.worldObj.rand.nextFloat());
/* 186 */         if (newent != null) {
/* 187 */           EntityCannonFodder cf = (EntityCannonFodder)newent;
/* 188 */           cf.func_152115_b(func_152113_b());
/* 189 */           cf.setTamed(true);
/* 190 */           cf.setStuff(this.hat_color, this.is_activated, this.name_one, this.name_two);
/*     */         } 
/*     */       } 
/*     */       
/* 194 */       playTameEffect(true);
/* 195 */       this.worldObj.playSoundAtEntity((Entity)par1EntityPlayer, "random.explode", 0.75F, 2.0F);
/*     */       
/* 197 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*     */         
/* 199 */         var2.stackSize--;
/* 200 */         if (var2.stackSize <= 0)
/*     */         {
/* 202 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*     */         }
/*     */       } 
/* 205 */       return true;
/* 206 */     }  if (this.is_activated == 2 && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/* 207 */       if (isSitting()) {
/* 208 */         setSitting(false);
/* 209 */         playTameEffect(true);
/*     */       } else {
/* 211 */         setSitting(true);
/* 212 */         playTameEffect(false);
/* 213 */         this.px = (int)this.posX;
/* 214 */         this.py = (int)this.posY;
/* 215 */         this.pz = (int)this.posZ;
/*     */       } 
/* 217 */       return true;
/*     */     } 
/*     */     
/* 220 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, String par1, double par2, double par4, double par6) {
/* 229 */     Entity var8 = null;
/* 230 */     var8 = EntityList.createEntityByName(par1, par0World);
/* 231 */     if (var8 != null) {
/*     */ 
/*     */       
/* 234 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/*     */ 
/*     */       
/* 237 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 239 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/* 241 */     return var8;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setStuff(int hc, int ia, String s1, String s2) {
/* 246 */     this.hat_color = hc;
/* 247 */     this.is_activated = ia;
/* 248 */     this.name_one = s1;
/* 249 */     this.name_two = s2;
/* 250 */     enablePersistence();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHatColor() {
/* 256 */     return this.hat_color;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get_is_activated() {
/* 261 */     return this.is_activated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 270 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 271 */     if (this.name_one == null) {
/*     */       
/* 273 */       par1NBTTagCompound.setString("NameOne", "");
/*     */     }
/*     */     else {
/*     */       
/* 277 */       par1NBTTagCompound.setString("NameOne", this.name_one);
/*     */     } 
/* 279 */     if (this.name_two == null) {
/*     */       
/* 281 */       par1NBTTagCompound.setString("NameTwo", "");
/*     */     }
/*     */     else {
/*     */       
/* 285 */       par1NBTTagCompound.setString("NameTwo", this.name_two);
/*     */     } 
/* 287 */     par1NBTTagCompound.setInteger("IsActivated", this.is_activated);
/* 288 */     par1NBTTagCompound.setInteger("HatColor", this.hat_color);
/* 289 */     par1NBTTagCompound.setInteger("PatrolX", this.px);
/* 290 */     par1NBTTagCompound.setInteger("PatrolY", this.py);
/* 291 */     par1NBTTagCompound.setInteger("PatrolZ", this.pz);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 299 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 300 */     this.name_one = par1NBTTagCompound.getString("NameOne");
/* 301 */     if (this.name_one != null && this.name_one.equals("")) this.name_one = null; 
/* 302 */     this.name_two = par1NBTTagCompound.getString("NameTwo");
/* 303 */     if (this.name_two != null && this.name_two.equals("")) this.name_two = null; 
/* 304 */     this.is_activated = par1NBTTagCompound.getInteger("IsActivated");
/* 305 */     this.hat_color = par1NBTTagCompound.getInteger("HatColor");
/* 306 */     this.px = par1NBTTagCompound.getInteger("PatrolX");
/* 307 */     this.py = par1NBTTagCompound.getInteger("PatrolY");
/* 308 */     this.pz = par1NBTTagCompound.getInteger("PatrolZ");
/* 309 */     if (this.name_one != null) {
/* 310 */       setTamed(true);
/* 311 */       func_152115_b(this.name_one);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 320 */     if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) return false;
/*     */     
/* 322 */     if (par1EntityLiving == null)
/*     */     {
/* 324 */       return false;
/*     */     }
/* 326 */     if (par1EntityLiving == this)
/*     */     {
/* 328 */       return false;
/*     */     }
/* 330 */     if (!par1EntityLiving.isEntityAlive())
/*     */     {
/* 332 */       return false;
/*     */     }
/* 334 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*     */     {
/*     */       
/* 337 */       return false;
/*     */     }
/*     */     
/* 340 */     if (isSitting()) {
/*     */       
/* 342 */       double dx = this.px - par1EntityLiving.posX;
/* 343 */       double dy = this.py - par1EntityLiving.posY;
/* 344 */       double dz = this.pz - par1EntityLiving.posZ;
/* 345 */       if (dx * dx + dy * dy + dz * dz > 144.0D) return false;
/*     */     
/*     */     } 
/* 348 */     if (par1EntityLiving instanceof net.minecraft.entity.monster.EntityMob)
/*     */     {
/* 350 */       return true;
/*     */     }
/*     */     
/* 353 */     if (par1EntityLiving instanceof EntityCannonFodder) {
/*     */       
/* 355 */       EntityCannonFodder cf = (EntityCannonFodder)par1EntityLiving;
/* 356 */       int i = cf.getHatColor();
/* 357 */       if (i != 0 && i != this.hat_color) return true; 
/* 358 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 362 */     if (par1EntityLiving instanceof EntityPlayer) {
/*     */       
/* 364 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 365 */       if (p.capabilities.isCreativeMode == true) {
/* 366 */         return false;
/*     */       }
/* 368 */       if (this.name_one != null && this.name_one.equals(p.getUniqueID().toString())) return false; 
/* 369 */       if (this.name_two != null && this.name_two.equals(p.getUniqueID().toString())) return false; 
/* 370 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 374 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityLivingBase findSomethingToAttack() {
/* 379 */     List<?> var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 4.0D, 10.0D));
/* 380 */     Collections.sort(var5, this.LocalTargetSorter);
/* 381 */     Iterator<?> var2 = var5.iterator();
/* 382 */     Entity var3 = null;
/* 383 */     EntityLivingBase var4 = null;
/*     */     
/* 385 */     while (var2.hasNext()) {
/*     */       
/* 387 */       var3 = (Entity)var2.next();
/* 388 */       var4 = (EntityLivingBase)var3;
/*     */       
/* 390 */       if (isSuitableTarget(var4, false))
/*     */       {
/* 392 */         return var4;
/*     */       }
/*     */     } 
/* 395 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalArmorValue() {
/* 403 */     if (this.is_activated == 2) return 3; 
/* 404 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void attackEntityAsFodder(Entity par1Entity, float f) {
/* 409 */     par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAITasks() {
/* 416 */     if (this.isDead)
/* 417 */       return;  super.updateAITasks();
/* 418 */     if (this.worldObj.rand.nextInt(200) == 1) setRevengeTarget(null); 
/* 419 */     if (this.is_activated != 2)
/* 420 */       return;  int pfreq = 5;
/* 421 */     int sfreq = 7;
/* 422 */     float dm = 4.0F;
/* 423 */     if (this instanceof Chipmunk) {
/* 424 */       dm = 3.0F;
/* 425 */       sfreq = 6;
/*     */     } 
/* 427 */     if (this instanceof Lizard) {
/* 428 */       dm = 6.0F;
/* 429 */       sfreq = 8;
/*     */     } 
/* 431 */     if (this instanceof VelocityRaptor) {
/* 432 */       sfreq = 6;
/* 433 */       pfreq = 4;
/*     */     } 
/* 435 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(pfreq) == 1) {
/* 436 */       EntityLivingBase e = findSomethingToAttack();
/* 437 */       if (e != null) {
/* 438 */         getNavigator().tryMoveToEntityLiving((Entity)e, 1.25D);
/* 439 */         if (getDistanceSqToEntity((Entity)e) < 9.0D)
/*     */         {
/* 441 */           if (this.rand.nextInt(sfreq + 1) == 0 || this.rand.nextInt(sfreq) == 1)
/*     */           {
/* 443 */             attackEntityAsFodder((Entity)e, dm);
/*     */           }
/*     */         }
/*     */       }
/* 447 */       else if (isSitting()) {
/* 448 */         getNavigator().tryMoveToXYZ(this.px, this.py, this.pz, 0.6499999761581421D);
/*     */       } 
/*     */     } 
/*     */     
/* 452 */     if (this.worldObj.rand.nextInt(250) == 1) heal(1.0F);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChild(EntityAgeable entityageable) {
/* 459 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\EntityCannonFodder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
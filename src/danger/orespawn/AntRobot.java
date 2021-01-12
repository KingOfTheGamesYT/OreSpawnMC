/*      */ package danger.orespawn;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.EnumDifficulty;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AntRobot
/*      */   extends EntityLiving
/*      */ {
/*      */   private int boatPosRotationIncrements;
/*      */   private double boatX;
/*      */   private double boatY;
/*      */   private double boatZ;
/*      */   private double boatYaw;
/*      */   private double boatPitch;
/*   64 */   private int playing = 0;
/*      */ 
/*      */   
/*   67 */   private GenericTargetSorter TargetSorter = null;
/*   68 */   private float moveSpeed = 0.3F;
/*   69 */   private RenderSpiderRobotInfo renderdata = new RenderSpiderRobotInfo();
/*   70 */   private int didonce = 0;
/*   71 */   private int rideTicker = 0;
/*   72 */   private int owned = 0;
/*      */ 
/*      */   
/*      */   public AntRobot(World par1World) {
/*   76 */     super(par1World);
/*   77 */     setSize(2.75F, 1.25F);
/*   78 */     this.riddenByEntity = null;
/*   79 */     this.TargetSorter = new GenericTargetSorter((Entity)this);
/*   80 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIWatchClosest(this, EntityPlayer.class, 12.0F));
/*   81 */     this.tasks.addTask(2, (EntityAIBase)new EntityAILookIdle(this));
/*   82 */     this.isImmuneToFire = true;
/*   83 */     this.experienceValue = OreSpawnMain.AntRobot_stats.health / 2;
/*      */   }
/*      */ 
/*      */   
/*      */   public AntRobot(World par1World, double par2, double par4, double par6) {
/*   88 */     this(par1World);
/*   89 */     setPosition(par2, par4 + this.yOffset, par6);
/*   90 */     this.motionX = 0.0D;
/*   91 */     this.motionY = 0.0D;
/*   92 */     this.motionZ = 0.0D;
/*   93 */     this.prevPosX = par2;
/*   94 */     this.prevPosY = par4;
/*   95 */     this.prevPosZ = par6;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  100 */     super.applyEntityAttributes();
/*  101 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(OreSpawnMain.AntRobot_stats.health);
/*  102 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  103 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  104 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OreSpawnMain.AntRobot_stats.attack);
/*      */   }
/*      */   
/*      */   protected boolean canDespawn() {
/*  108 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOwned() {
/*  113 */     this.owned = 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getOwned() {
/*  118 */     return this.owned;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  126 */     return OreSpawnMain.AntRobot_stats.defense;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void updateAITasks() {
/*  131 */     EntityLivingBase e = null;
/*  132 */     if (this.isDead)
/*  133 */       return;  if (this.riddenByEntity != null)
/*  134 */       return;  super.updateAITasks();
/*  135 */     if (this.owned == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
/*  136 */       if (this.worldObj.rand.nextInt(20) == 0) {
/*  137 */         feetFindSomethingToHit();
/*      */       }
/*      */       
/*  140 */       if (this.worldObj.rand.nextInt(150) == 0) setAttackTarget(null); 
/*  141 */       e = getAttackTarget();
/*  142 */       if (e != null && !e.isEntityAlive()) {
/*  143 */         setAttackTarget(null);
/*  144 */         e = null;
/*      */       } 
/*  146 */       if (e == null) e = findSomethingToAttack(2.0F, false); 
/*  147 */       if (e != null) {
/*  148 */         faceEntity((Entity)e, 10.0F, 10.0F);
/*  149 */         if (getDistanceSqToEntity((Entity)e) > 16.0D) {
/*      */           
/*  151 */           double d1 = e.posZ - this.posZ;
/*  152 */           double d2 = e.posX - this.posX;
/*  153 */           double dd = Math.atan2(d1, d2);
/*  154 */           goThisWay(0.2D * Math.cos(dd), 0.2D * Math.sin(dd));
/*      */         } 
/*      */       } else {
/*  157 */         setAttacking(0);
/*      */       } 
/*      */       
/*  160 */       if (e != null && this.worldObj.rand.nextInt(15) == 0) {
/*  161 */         e = getAttackTarget();
/*  162 */         if (e == null) e = findSomethingToAttack(2.0F, true); 
/*  163 */         if (e != null) {
/*  164 */           if (getDistanceSqToEntity((Entity)e) < ((6.0F + e.width / 2.0F) * (6.0F + e.width / 2.0F))) {
/*  165 */             setAttacking(1);
/*  166 */             attackEntityAsMob((Entity)e);
/*      */           } else {
/*  168 */             setAttacking(0);
/*      */           } 
/*      */         } else {
/*  171 */           setAttacking(0);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITick() {
/*  182 */     if (this.riddenByEntity != null)
/*  183 */       return;  super.updateAITick();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void initLegData() {
/*  189 */     if (this.renderdata == null) {
/*  190 */       this.renderdata = new RenderSpiderRobotInfo();
/*      */     }
/*  192 */     for (int i = 0; i < 6; i++) {
/*  193 */       this.renderdata.ycurrentangle[i] = 0.0F;
/*  194 */       this.renderdata.ywantedangle[i] = 0.0F;
/*  195 */       this.renderdata.ydisplayangle[i] = 0.0F;
/*  196 */       this.renderdata.yvelocity[i] = 0.0F;
/*  197 */       this.renderdata.ymid[i] = 0.0F;
/*  198 */       this.renderdata.yoff[i] = 0.0F;
/*  199 */       this.renderdata.yrange[i] = 0.0F;
/*  200 */       this.renderdata.udcurrentangle[i] = 0.0F;
/*  201 */       this.renderdata.udwantedangle[i] = 0.0F;
/*  202 */       this.renderdata.uddisplayangle[i] = 0.0F;
/*  203 */       this.renderdata.udvelocity[i] = 0.0F;
/*  204 */       this.renderdata.p1xangle[i] = 0.7853981633974483D;
/*  205 */       this.renderdata.p2xangle[i] = 0.0D;
/*  206 */       this.renderdata.p3xangle[i] = -0.7853981633974483D;
/*  207 */       this.renderdata.pxvelocity[i] = 0.0F;
/*  208 */       this.renderdata.foot_xpos[i] = (float)this.posX;
/*  209 */       this.renderdata.foot_ypos[i] = (float)this.posY;
/*  210 */       this.renderdata.foot_zpos[i] = (float)this.posZ;
/*  211 */       this.renderdata.realposx[i] = 0.0F;
/*  212 */       this.renderdata.realposy[i] = 0.0F;
/*  213 */       this.renderdata.realposz[i] = 0.0F;
/*  214 */       this.renderdata.legoff[i] = 0.0F;
/*  215 */       this.renderdata.footup[i] = 1;
/*  216 */       this.renderdata.uppoint[i] = 0.0F;
/*  217 */       this.renderdata.footingticker[i] = 0;
/*  218 */       this.renderdata.gpcounter = 0;
/*  219 */       if (i == 0) {
/*  220 */         this.renderdata.legoff[i] = 0.75F;
/*  221 */         this.renderdata.ymid[i] = 0.0F;
/*  222 */         this.renderdata.yrange[i] = 0.2617994F;
/*  223 */         this.renderdata.pairedwith[i] = 1;
/*  224 */         this.renderdata.yoff[i] = -0.75F;
/*      */       } 
/*  226 */       if (i == 1) {
/*  227 */         this.renderdata.legoff[i] = 0.75F;
/*  228 */         this.renderdata.ymid[i] = 3.1415927F;
/*  229 */         this.renderdata.yrange[i] = -0.2617994F;
/*  230 */         this.renderdata.pairedwith[i] = 0;
/*  231 */         this.renderdata.yoff[i] = -0.75F;
/*      */       } 
/*  233 */       if (i == 2) {
/*  234 */         this.renderdata.legoff[i] = 1.0F;
/*  235 */         this.renderdata.ymid[i] = -0.7853982F;
/*  236 */         this.renderdata.yrange[i] = 0.2617994F;
/*  237 */         this.renderdata.pairedwith[i] = 3;
/*  238 */         this.renderdata.yoff[i] = -0.75F;
/*      */       } 
/*  240 */       if (i == 3) {
/*  241 */         this.renderdata.legoff[i] = 1.0F;
/*  242 */         this.renderdata.ymid[i] = 3.9269907F;
/*  243 */         this.renderdata.yrange[i] = -0.2617994F;
/*  244 */         this.renderdata.pairedwith[i] = 2;
/*  245 */         this.renderdata.yoff[i] = -0.75F;
/*      */       } 
/*      */       
/*  248 */       if (i == 4) {
/*  249 */         this.renderdata.legoff[i] = 1.15F;
/*  250 */         this.renderdata.ymid[i] = 0.7853982F;
/*  251 */         this.renderdata.yrange[i] = 0.2617994F;
/*  252 */         this.renderdata.pairedwith[i] = 5;
/*  253 */         this.renderdata.yoff[i] = -0.75F;
/*      */       } 
/*  255 */       if (i == 5) {
/*  256 */         this.renderdata.legoff[i] = 1.15F;
/*  257 */         this.renderdata.ymid[i] = 2.3561945F;
/*  258 */         this.renderdata.yrange[i] = -0.2617994F;
/*  259 */         this.renderdata.pairedwith[i] = 4;
/*  260 */         this.renderdata.yoff[i] = -0.75F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private float getNewVelocity(float v, float diff, float curval) {
/*  269 */     float tv = v;
/*      */     
/*  271 */     tv *= 18.0F;
/*  272 */     if (tv < 2.0F) tv = 2.0F; 
/*  273 */     if (tv > 8.0F) tv = 8.0F;
/*      */     
/*  275 */     if (diff > 0.0F) {
/*  276 */       if (diff < 0.008726646259971648D * tv) {
/*  277 */         curval = 0.0F;
/*      */       } else {
/*  279 */         curval = (float)(curval + 0.004363323129985824D * tv);
/*  280 */         if (diff < 0.06981317007977318D * tv) curval = (float)(0.017453292519943295D * tv); 
/*  281 */         if (diff < 0.03490658503988659D * tv) curval = (float)(0.008726646259971648D * tv); 
/*  282 */         if (curval > 0.06981317007977318D * tv) curval = (float)(0.06981317007977318D * tv);
/*      */       
/*      */       } 
/*  285 */     } else if (diff > -0.008726646259971648D * tv) {
/*  286 */       curval = 0.0F;
/*      */     } else {
/*  288 */       curval = (float)(curval - 0.004363323129985824D * tv);
/*  289 */       if (diff > -0.06981317007977318D * tv) curval = -((float)(0.017453292519943295D * tv)); 
/*  290 */       if (diff > -0.03490658503988659D * tv) curval = -((float)(0.008726646259971648D * tv)); 
/*  291 */       if (curval < -0.06981317007977318D * tv) curval = -((float)(0.06981317007977318D * tv));
/*      */     
/*      */     } 
/*  294 */     return curval;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateLegs() {
/*  308 */     if (!this.worldObj.isRemote)
/*  309 */       return;  this.rotationYaw %= 360.0F;
/*  310 */     for (; this.rotationYaw < 0.0F; this.rotationYaw += 360.0F);
/*  311 */     this.renderdata.gpcounter++;
/*      */     
/*  313 */     if (this.didonce == 0) {
/*  314 */       this.didonce = 1;
/*  315 */       initLegData();
/*      */     } 
/*      */ 
/*      */     
/*  319 */     float d1 = (float)(this.prevPosX - this.posX);
/*  320 */     float d2 = (float)(this.prevPosY - this.posY);
/*  321 */     float d3 = (float)(this.prevPosZ - this.posZ);
/*  322 */     float realv = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  327 */     int i = 0;
/*      */     
/*  329 */     for (i = 0; i < 6; i++) {
/*  330 */       int fcount = 0;
/*  331 */       this.renderdata.footingticker[i] = this.renderdata.footingticker[i] + 1;
/*      */       
/*  333 */       this.renderdata.realposx[i] = (float)(this.posX - this.renderdata.legoff[i] * Math.sin(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i]));
/*  334 */       this.renderdata.realposz[i] = (float)(this.posZ + this.renderdata.legoff[i] * Math.cos(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i]));
/*  335 */       this.renderdata.realposy[i] = (float)this.posY + this.renderdata.yoff[i];
/*      */       
/*  337 */       int it = this.renderdata.footingticker[i] + this.renderdata.footingticker[this.renderdata.pairedwith[i]];
/*  338 */       if (it > 50 && this.renderdata.footingticker[i] > this.renderdata.footingticker[this.renderdata.pairedwith[i]]) {
/*  339 */         this.renderdata.footingticker[i] = 0;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  344 */       d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
/*  345 */       d2 = this.renderdata.realposy[i] - this.renderdata.foot_ypos[i];
/*  346 */       d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
/*  347 */       float dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*  348 */       dd *= 16.0F;
/*      */       
/*  350 */       float da = (float)(Math.abs(this.renderdata.ycurrentangle[i] - Math.toRadians(MathHelper.wrapAngleTo180_double(this.rotationYaw)) + this.renderdata.ymid[i]) % 6.283185307179586D);
/*  351 */       if (da > Math.PI) da = (float)(da - 6.283185307179586D); 
/*  352 */       if (da < -3.141592653589793D) da = (float)(da + 6.283185307179586D); 
/*  353 */       da = Math.abs(da);
/*      */ 
/*      */       
/*  356 */       if (dd > 144.0F || dd < 22.0F || da > Math.abs(this.renderdata.yrange[i]) * 8.0F / 6.0F || Math.abs(this.renderdata.udcurrentangle[i]) > 1.25D || this.renderdata.footingticker[i] == 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  363 */         findNewFooting(i);
/*  364 */         d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
/*  365 */         d2 = this.renderdata.realposy[i] - this.renderdata.foot_ypos[i];
/*  366 */         d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
/*  367 */         dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*  368 */         dd *= 16.0F;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  375 */       float c1 = (float)(49.0D * Math.cos(this.renderdata.p2xangle[i] - this.renderdata.p1xangle[i]));
/*  376 */       float c2 = 49.0F;
/*  377 */       float c3 = (float)(49.0D * Math.cos(this.renderdata.p2xangle[i] - this.renderdata.p3xangle[i]));
/*  378 */       float cc = c1 + c2 + c3;
/*      */       
/*  380 */       float diff = cc - dd;
/*  381 */       this.renderdata.pxvelocity[i] = getNewVelocity(realv, (float)(diff * Math.PI / 360.0D), this.renderdata.pxvelocity[i]);
/*  382 */       if (this.renderdata.pxvelocity[i] == 0.0F || Math.abs(diff) < 8.0F) fcount++; 
/*  383 */       this.renderdata.p1xangle[i] = this.renderdata.p1xangle[i] + this.renderdata.pxvelocity[i];
/*  384 */       this.renderdata.p2xangle[i] = 0.0D;
/*  385 */       this.renderdata.p3xangle[i] = -this.renderdata.p1xangle[i];
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  390 */       if (this.renderdata.uppoint[i] != 0.0F) {
/*  391 */         dd = (float)Math.atan2(dd, (this.renderdata.realposy[i] - this.renderdata.uppoint[i]) * 16.0D);
/*      */       } else {
/*  393 */         dd = (float)Math.atan2(dd, (this.renderdata.realposy[i] - this.renderdata.foot_ypos[i]) * 16.0D);
/*      */       } 
/*  395 */       this.renderdata.udwantedangle[i] = (float)(dd - 1.5707963267948966D);
/*  396 */       for (; this.renderdata.udwantedangle[i] > Math.PI; this.renderdata.udwantedangle[i] = (float)(this.renderdata.udwantedangle[i] - 6.283185307179586D));
/*  397 */       for (; this.renderdata.udwantedangle[i] < -3.141592653589793D; this.renderdata.udwantedangle[i] = (float)(this.renderdata.udwantedangle[i] + 6.283185307179586D));
/*  398 */       double rhm = this.renderdata.udwantedangle[i];
/*  399 */       double rhdir = this.renderdata.udcurrentangle[i];
/*      */ 
/*      */       
/*  402 */       double rdv = (rhm - rhdir) % 6.283185307179586D;
/*  403 */       for (; rdv > Math.PI; rdv -= 6.283185307179586D);
/*  404 */       for (; rdv < -3.141592653589793D; rdv += 6.283185307179586D);
/*  405 */       diff = (float)rdv;
/*      */ 
/*      */ 
/*      */       
/*  409 */       this.renderdata.udvelocity[i] = getNewVelocity(realv * 2.0F, diff, this.renderdata.udvelocity[i]);
/*  410 */       if (this.renderdata.udvelocity[i] == 0.0F || Math.abs(diff) < 0.03490658503988659D) {
/*  411 */         this.renderdata.uppoint[i] = 0.0F;
/*  412 */         fcount++;
/*      */       } 
/*  414 */       rhdir += this.renderdata.udvelocity[i];
/*      */       
/*  416 */       for (; rhdir > Math.PI; rhdir -= 6.283185307179586D);
/*  417 */       for (; rhdir < -3.141592653589793D; rhdir += 6.283185307179586D);
/*      */       
/*  419 */       dd = this.renderdata.udcurrentangle[i] = (float)rhdir;
/*  420 */       this.renderdata.uddisplayangle[i] = dd;
/*      */ 
/*      */       
/*  423 */       d1 = this.renderdata.realposx[i] - this.renderdata.foot_xpos[i];
/*  424 */       d3 = this.renderdata.realposz[i] - this.renderdata.foot_zpos[i];
/*  425 */       dd = (float)Math.atan2(d3, d1);
/*  426 */       this.renderdata.ywantedangle[i] = dd; rhm = dd;
/*  427 */       rhdir = this.renderdata.ycurrentangle[i];
/*      */ 
/*      */       
/*  430 */       rdv = (rhm - rhdir) % 6.283185307179586D;
/*  431 */       if (rdv > Math.PI) rdv -= 6.283185307179586D; 
/*  432 */       if (rdv < -3.141592653589793D) rdv += 6.283185307179586D; 
/*  433 */       diff = (float)rdv;
/*      */       
/*  435 */       this.renderdata.yvelocity[i] = getNewVelocity(realv, diff, this.renderdata.yvelocity[i]);
/*  436 */       if (this.renderdata.yvelocity[i] == 0.0F || Math.abs(diff) < 0.03490658503988659D) fcount++; 
/*  437 */       this.renderdata.ycurrentangle[i] = this.renderdata.ycurrentangle[i] + this.renderdata.yvelocity[i];
/*  438 */       for (; this.renderdata.ycurrentangle[i] > Math.PI; this.renderdata.ycurrentangle[i] = (float)(this.renderdata.ycurrentangle[i] - 6.283185307179586D));
/*  439 */       for (; this.renderdata.ycurrentangle[i] < -3.141592653589793D; this.renderdata.ycurrentangle[i] = (float)(this.renderdata.ycurrentangle[i] + 6.283185307179586D));
/*      */ 
/*      */       
/*  442 */       dd = (float)(this.renderdata.ycurrentangle[i] - Math.toRadians(MathHelper.wrapAngleTo180_double(this.rotationYaw)) - 1.5707963267948966D);
/*  443 */       for (; dd > Math.PI; dd = (float)(dd - 6.283185307179586D));
/*  444 */       for (; dd < -3.141592653589793D; dd = (float)(dd + 6.283185307179586D));
/*  445 */       this.renderdata.ydisplayangle[i] = dd;
/*      */       
/*  447 */       if (fcount == 3) {
/*  448 */         this.renderdata.footup[i] = 0;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void findNewFooting(int i) {
/*  457 */     float f = 9.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  463 */     int found = 0;
/*      */ 
/*      */     
/*  466 */     float range = 0.0F;
/*      */     
/*  468 */     double rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */     
/*  470 */     double pi = 3.1415926545D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  476 */     this.renderdata.footingticker[i] = 0;
/*      */     
/*  478 */     float d1 = (float)(this.posX - this.prevPosX);
/*  479 */     float d3 = (float)(this.posZ - this.prevPosZ);
/*  480 */     double rhm = Math.atan2(d3, d1);
/*  481 */     double velocity = Math.sqrt((d1 * d1 + d3 * d3));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  487 */     double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/*  488 */     if (rdv > pi) rdv -= pi * 2.0D; 
/*  489 */     rdv = Math.abs(rdv);
/*  490 */     if (Math.abs(velocity) < 0.01D) rdv = 0.0D; 
/*  491 */     range = this.renderdata.yrange[i];
/*  492 */     range *= 0.8F;
/*  493 */     if (Math.abs((this.prevRotationYaw - this.rotationYaw) % 360.0F) > 0.75F) range = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  498 */     if (i >= 4) f = 4.0F; 
/*  499 */     if (rdv > 1.5D) {
/*      */       
/*  501 */       range = -range;
/*  502 */       f = 4.0F;
/*  503 */       if (i >= 4) f = 9.0F; 
/*      */     } 
/*  505 */     if (i == 0 || i == 1) f = 6.0F;
/*      */ 
/*      */ 
/*      */     
/*  509 */     float fx = (float)(this.renderdata.realposx[i] - (f / 2.0F) * Math.sin(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i])), deffx = fx;
/*  510 */     float fz = (float)(this.renderdata.realposz[i] + (f / 2.0F) * Math.cos(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i])), deffz = fz;
/*  511 */     float fy = this.renderdata.realposy[i] - 1.0F, deffy = fy;
/*  512 */     float oldf = f;
/*  513 */     int span = 1;
/*  514 */     while (found == 0 && f > 2.5F) {
/*  515 */       fx = (float)(this.renderdata.realposx[i] - f * Math.sin(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i] - range));
/*  516 */       fz = (float)(this.renderdata.realposz[i] + f * Math.cos(Math.toRadians(MathHelper.wrapAngleTo180_double((this.rotationYaw + 90.0F))) + this.renderdata.ymid[i] - range));
/*  517 */       fy = this.renderdata.realposy[i];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  542 */       for (int j = 8; found == 0 && j > -9; j--) {
/*  543 */         for (int m = -span; found == 0 && m <= span; m++) {
/*  544 */           for (int n = -span; found == 0 && n <= span; n++) {
/*  545 */             Block blk = this.worldObj.getBlock((int)fx + m, (int)fy + j, (int)fz + n);
/*  546 */             if (blk != Blocks.air && 
/*  547 */               this.worldObj.getBlock((int)fx + m, (int)fy + j, (int)fz + n).getMaterial().isSolid()) {
/*  548 */               d1 = this.renderdata.realposx[i] - fx + m;
/*  549 */               float d2 = this.renderdata.realposy[i] - fy + j + 1.0F;
/*  550 */               d3 = this.renderdata.realposz[i] - fz + n;
/*  551 */               float dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*  552 */               dd *= 16.0F;
/*  553 */               if (dd <= 144.0F) {
/*      */ 
/*      */ 
/*      */                 
/*  557 */                 fy += (j + 1);
/*  558 */                 fx += m;
/*  559 */                 fz += n;
/*  560 */                 found = 1;
/*      */ 
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  570 */       f--;
/*  571 */       if (f < 2.5F && 
/*  572 */         range != 0.0F) {
/*  573 */         range = 0.0F;
/*  574 */         span = 3;
/*  575 */         f = oldf;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  583 */     if (found == 0) {
/*  584 */       fx = deffx;
/*  585 */       fy = deffy;
/*  586 */       fz = deffz;
/*      */     } 
/*      */     
/*  589 */     float sfx = this.renderdata.foot_xpos[i];
/*  590 */     float sfy = this.renderdata.foot_ypos[i];
/*  591 */     float sfz = this.renderdata.foot_zpos[i];
/*  592 */     this.renderdata.foot_xpos[i] = fx;
/*  593 */     this.renderdata.foot_ypos[i] = fy;
/*  594 */     this.renderdata.foot_zpos[i] = fz;
/*      */ 
/*      */     
/*  597 */     if (this.renderdata.footup[i] == 0) {
/*  598 */       this.renderdata.footup[i] = 1;
/*      */       
/*  600 */       d1 = sfx - fx;
/*  601 */       float d2 = sfy - fy;
/*  602 */       d3 = sfz - fz;
/*  603 */       float dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*  604 */       dd *= 16.0F;
/*  605 */       d1 = (sfy + fy) / 2.0F;
/*  606 */       if (dd > 3.0F) {
/*  607 */         d1 += 0.3F;
/*      */       }
/*  609 */       if (dd > 24.0F) {
/*  610 */         d1 += 0.6F;
/*      */       }
/*  612 */       if (dd > 50.0F) {
/*  613 */         d1 += 0.6F;
/*      */       }
/*  615 */       this.renderdata.uppoint[i] = d1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldRiderSit() {
/*  627 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTrackingRange() {
/*  632 */     return 128;
/*      */   }
/*      */   
/*      */   public int getUpdateFrequency() {
/*  636 */     return 10;
/*      */   }
/*      */   
/*      */   public boolean sendsVelocityUpdates() {
/*  640 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canTriggerWalking() {
/*  653 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  659 */     super.entityInit();
/*  660 */     enablePersistence();
/*  661 */     initLegData();
/*  662 */     int i = 0;
/*  663 */     this.dataWatcher.addObject(20, Integer.valueOf(i));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderSpiderRobotInfo getRenderSpiderRobotInfo() {
/*  670 */     return this.renderdata;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBePushed() {
/*  679 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getMountedYOffset() {
/*  687 */     return 0.55D + Math.cos((this.rideTicker * 0.19F)) * 0.02D;
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateRiderPosition() {
/*  692 */     if (this.riddenByEntity != null) {
/*      */       
/*  694 */       float f = -1.25F;
/*  695 */       f = (float)(f + Math.cos((this.rideTicker * 0.33F)) * 0.05D);
/*  696 */       this.riddenByEntity.setPosition(this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/*  710 */     if (par1DamageSource.getDamageType().equals("inWall")) {
/*  711 */       return false;
/*      */     }
/*  713 */     if (par1DamageSource.getDamageType().equals("cactus")) {
/*  714 */       return false;
/*      */     }
/*  716 */     if (par1DamageSource.getDamageType().equals("inFire")) {
/*  717 */       return false;
/*      */     }
/*  719 */     if (par1DamageSource.getDamageType().equals("onFire")) {
/*  720 */       return false;
/*      */     }
/*  722 */     if (par1DamageSource.getDamageType().equals("magic")) {
/*  723 */       return false;
/*      */     }
/*  725 */     if (par1DamageSource.getDamageType().equals("starve")) {
/*  726 */       return false;
/*      */     }
/*      */     
/*  729 */     Entity e = par1DamageSource.getEntity();
/*  730 */     if (e != null && e instanceof EntityLiving) {
/*      */       
/*  732 */       setAttackTarget((EntityLivingBase)e);
/*  733 */       faceEntity(e, 20.0F, 20.0F);
/*      */     } 
/*      */ 
/*      */     
/*  737 */     return super.attackEntityFrom(par1DamageSource, par2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void fall(float par1) {}
/*      */ 
/*      */   
/*      */   protected void updateFallState(double par1, boolean par3) {}
/*      */ 
/*      */   
/*      */   public boolean canBeCollidedWith() {
/*  749 */     return !this.isDead;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
/*  761 */     if (this.riddenByEntity != null) {
/*      */       
/*  763 */       this.boatPosRotationIncrements = par9 + 8;
/*      */     }
/*      */     else {
/*      */       
/*  767 */       this.boatPosRotationIncrements = par9 + 6;
/*      */     } 
/*      */ 
/*      */     
/*  771 */     this.boatX = par1;
/*  772 */     this.boatY = par3;
/*  773 */     this.boatZ = par5;
/*  774 */     this.boatYaw = par7;
/*  775 */     this.boatPitch = par8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setVelocity(double par1, double par3, double par5) {
/*  786 */     if (this.riddenByEntity == null) {
/*  787 */       super.setVelocity(par1, par3, par5);
/*      */     }
/*      */   }
/*      */   
/*      */   public void onUpdate() {
/*  792 */     super.onUpdate();
/*  793 */     setFire(0);
/*  794 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && !this.worldObj.isRemote && this.riddenByEntity != null && this.worldObj.rand.nextInt(50) == 0) {
/*  795 */       feetFindSomethingToHit();
/*      */     }
/*      */     
/*  798 */     if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && !this.worldObj.isRemote && this.riddenByEntity != null && this.worldObj.rand.nextInt(9) == 0) {
/*  799 */       EntityLivingBase e = null;
/*  800 */       e = findSomethingToAttack(1.0F, true);
/*  801 */       if (e != null) {
/*  802 */         if (getDistanceSqToEntity((Entity)e) < ((6.0F + e.width / 2.0F) * (6.0F + e.width / 2.0F))) {
/*  803 */           setAttacking(1);
/*  804 */           attackEntityAsMob((Entity)e);
/*      */         } 
/*      */       } else {
/*  807 */         setAttacking(0);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  812 */     float f = 4.0F;
/*      */     
/*  814 */     float dx = (float)(f * Math.cos(Math.toRadians((this.rotationYaw - 80.0F))));
/*  815 */     float dz = (float)(f * Math.sin(Math.toRadians((this.rotationYaw - 80.0F))));
/*  816 */     float dx2 = (float)(f * Math.cos(Math.toRadians((this.rotationYaw - 90.0F))));
/*  817 */     float dz2 = (float)(f * Math.sin(Math.toRadians((this.rotationYaw - 90.0F))));
/*      */     
/*  819 */     if (this.worldObj.rand.nextInt(18) == 0) {
/*  820 */       this.worldObj.spawnParticle("flame", this.posX + dx, this.posY + 0.5D, this.posZ + dz, (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0F), (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  826 */     if (this.worldObj.rand.nextInt(7) == 0) {
/*  827 */       this.worldObj.spawnParticle("smoke", this.posX + dx, this.posY + 0.5D, this.posZ + dz, (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0F), (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  833 */     if (this.worldObj.rand.nextInt(16) == 0) {
/*  834 */       this.worldObj.spawnParticle("fireworksSpark", this.posX + dx, this.posY + 0.5D, this.posZ + dz, (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0F), (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  841 */     dx = (float)(f * Math.cos(Math.toRadians((this.rotationYaw - 100.0F))));
/*  842 */     dz = (float)(f * Math.sin(Math.toRadians((this.rotationYaw - 100.0F))));
/*      */     
/*  844 */     if (this.worldObj.rand.nextInt(18) == 0) {
/*  845 */       this.worldObj.spawnParticle("flame", this.posX + dx, this.posY + 0.5D, this.posZ + dz, (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0F), (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  851 */     if (this.worldObj.rand.nextInt(7) == 0) {
/*  852 */       this.worldObj.spawnParticle("smoke", this.posX + dx, this.posY + 0.5D, this.posZ + dz, (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 10.0F), (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  858 */     if (this.worldObj.rand.nextInt(16) == 0) {
/*  859 */       this.worldObj.spawnParticle("fireworksSpark", this.posX + dx, this.posY + 0.5D, this.posZ + dz, (dx2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F), ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0F), (dz2 / f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 20.0F));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  874 */     List list = null;
/*  875 */     double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */     
/*  878 */     double d6 = (this.rand.nextFloat() * 2.0F - 1.0F);
/*  879 */     double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  885 */     double obstruction_factor = 0.0D;
/*      */     
/*  887 */     double relative_g = 0.0D;
/*      */     
/*  889 */     double max_speed = 0.3D;
/*  890 */     double gh = 1.75D;
/*      */ 
/*      */     
/*  893 */     int dist = 2;
/*      */     
/*  895 */     if (this.isDead)
/*      */       return; 
/*  897 */     if (this.riddenByEntity == null) {
/*  898 */       super.onLivingUpdate();
/*      */     }
/*  900 */     if (this.motionY > 0.8500000238418579D) this.motionY = 0.8500000238418579D; 
/*  901 */     if (this.motionY < -0.8500000238418579D) this.motionY = -0.8500000238418579D; 
/*  902 */     if (this.motionX < -1.25D) this.motionX = -1.25D; 
/*  903 */     if (this.motionX > 1.25D) this.motionX = 1.25D; 
/*  904 */     if (this.motionZ < -1.25D) this.motionZ = -1.25D; 
/*  905 */     if (this.motionZ > 1.25D) this.motionZ = 1.25D;
/*      */     
/*  907 */     this.prevPosX = this.posX;
/*  908 */     this.prevPosY = this.posY;
/*  909 */     this.prevPosZ = this.posZ;
/*      */     
/*  911 */     this.rideTicker += this.worldObj.rand.nextInt(3);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  916 */     if (this.playing > 0) this.playing--; 
/*  917 */     if (this.riddenByEntity != null && this.playing == 0 && this.worldObj.rand.nextInt(80) == 1) {
/*  918 */       this.worldObj.playSoundAtEntity((Entity)this, "orespawn:robotspider", 0.35F, 1.0F);
/*  919 */       this.playing = 125;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  926 */     if (this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  931 */       if (this.riddenByEntity == null) {
/*  932 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh + 1.0F), (int)this.posZ);
/*  933 */         if (bid == Blocks.air) bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ); 
/*  934 */         if (bid != Blocks.air && bid != Blocks.water && bid != Blocks.flowing_water && bid != Blocks.lava && bid != Blocks.flowing_lava) {
/*  935 */           this.motionY += 0.12D;
/*  936 */           this.posY += 0.12D;
/*  937 */           this.boatY += 0.12D;
/*      */         } else {
/*  939 */           this.motionY -= 0.002D;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  945 */       if (this.boatPosRotationIncrements > 0) {
/*      */         
/*  947 */         double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
/*  948 */         double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
/*  949 */         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
/*  950 */         setPosition(d4, d5, d11);
/*      */         
/*  952 */         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
/*  953 */         double d10 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
/*  954 */         if (this.riddenByEntity != null) d10 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw);
/*      */         
/*  956 */         this.rotationYaw = (float)(this.rotationYaw + d10 / this.boatPosRotationIncrements);
/*  957 */         setRotation(this.rotationYaw, this.rotationPitch);
/*      */         
/*  959 */         this.boatPosRotationIncrements--;
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */ 
/*      */         
/*  967 */         double d4 = this.posX + this.motionX;
/*  968 */         double d5 = this.posY + this.motionY;
/*  969 */         double d11 = this.posZ + this.motionZ;
/*  970 */         setPosition(d4, d5, d11);
/*      */ 
/*      */ 
/*      */         
/*  974 */         this.motionX *= 0.99D;
/*  975 */         this.motionY *= 0.95D;
/*  976 */         this.motionZ *= 0.99D;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  982 */       updateLegs();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  996 */       if (this.riddenByEntity != null) {
/*  997 */         gh = 2.25D;
/*  998 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ);
/*  999 */         if (bid != Blocks.air && bid != Blocks.water && bid != Blocks.flowing_water && bid != Blocks.lava && bid != Blocks.flowing_lava) {
/* 1000 */           this.motionY += 0.06D;
/* 1001 */           this.posY += 0.03D;
/*      */         } else {
/* 1003 */           this.motionY -= 0.02D;
/*      */         } 
/*      */       } else {
/* 1006 */         Block bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh + 1.0F), (int)this.posZ);
/* 1007 */         if (bid == Blocks.air) bid = this.worldObj.getBlock((int)this.posX, (int)((float)this.posY - (float)gh), (int)this.posZ); 
/* 1008 */         if (bid != Blocks.air && bid != Blocks.water && bid != Blocks.flowing_water && bid != Blocks.lava && bid != Blocks.flowing_lava) {
/* 1009 */           this.motionY += 0.15D;
/* 1010 */           this.posY += 0.15D;
/* 1011 */           this.boatY += 0.15D;
/*      */         } else {
/* 1013 */           this.motionY -= 0.002D;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1020 */       if (this.riddenByEntity != null) {
/* 1021 */         EntityPlayer pp = (EntityPlayer)this.riddenByEntity;
/*      */         
/* 1023 */         obstruction_factor = 0.0D;
/* 1024 */         dist = 3;
/* 1025 */         dist += (int)(velocity * 6.0D);
/*      */         
/* 1027 */         for (int k = 1; k < dist; k++) {
/* 1028 */           for (int i = 1; i < dist * 2; i++) {
/* 1029 */             for (int j = -90; j <= 90; j += 30) {
/* 1030 */               double dx = i * Math.cos(Math.toRadians((this.rotationYaw + 90.0F + j)));
/* 1031 */               double dz = i * Math.sin(Math.toRadians((this.rotationYaw + 90.0F + j)));
/* 1032 */               Block block = this.worldObj.getBlock((int)(this.posX + dx), (int)this.posY - k, (int)(this.posZ + dz));
/* 1033 */               if (block != Blocks.air && block != Blocks.water && block != Blocks.flowing_water && block != Blocks.lava && block != Blocks.flowing_lava) {
/* 1034 */                 obstruction_factor += 0.02D;
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1042 */         this.motionY += obstruction_factor * 0.05D;
/* 1043 */         this.posY += obstruction_factor * 0.05D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1052 */         double d4 = this.riddenByEntity.rotationYaw;
/* 1053 */         d4 %= 360.0D;
/* 1054 */         for (; d4 < 0.0D; d4 += 360.0D);
/* 1055 */         double d5 = this.rotationYaw;
/* 1056 */         d5 %= 360.0D;
/* 1057 */         for (; d5 < 0.0D; d5 += 360.0D);
/* 1058 */         relative_g = (d4 - d5) % 180.0D;
/* 1059 */         for (; relative_g < 0.0D; relative_g += 180.0D);
/* 1060 */         if (relative_g > 90.0D) relative_g -= 180.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1067 */         if (velocity > 0.01D) {
/*      */           
/* 1069 */           d4 = 1.85D - velocity;
/* 1070 */           d4 = Math.abs(d4);
/* 1071 */           if (d4 < 0.01D) d4 = 0.01D; 
/* 1072 */           if (d4 > 0.9D) d4 = 0.9D; 
/* 1073 */           this.rotationYaw = this.riddenByEntity.rotationYaw + (float)(relative_g * d4);
/*      */         } else {
/*      */           
/* 1076 */           this.rotationYaw = this.riddenByEntity.rotationYaw;
/*      */         } 
/* 1078 */         relative_g = Math.abs(relative_g) * velocity;
/* 1079 */         if (relative_g > 50.0D) relative_g = 0.0D;
/*      */ 
/*      */ 
/*      */         
/* 1083 */         this.rotationPitch = 0.0F;
/* 1084 */         setRotation(this.rotationYaw, this.rotationPitch);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1090 */         double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1098 */         double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
/* 1099 */         double rhm = Math.atan2(this.motionZ, this.motionX);
/* 1100 */         double rhdir = Math.toRadians(((this.riddenByEntity.rotationYaw + 90.0F) % 360.0F));
/* 1101 */         double rt = 0.0D;
/*      */         
/* 1103 */         double pi = 3.1415926545D;
/* 1104 */         double deltav = 0.0D;
/* 1105 */         float im = pp.moveForward;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1110 */         double rdv = Math.abs(rhm - rhdir) % pi * 2.0D;
/* 1111 */         if (rdv > pi) rdv -= pi * 2.0D; 
/* 1112 */         rdv = Math.abs(rdv);
/* 1113 */         if (Math.abs(newvelocity) < 0.01D) rdv = 0.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1121 */         if (rdv > 1.5D) newvelocity = -newvelocity;
/*      */         
/* 1123 */         if (Math.abs(im) > 0.001F) {
/* 1124 */           if (im > 0.0F) {
/* 1125 */             deltav = 0.05D;
/*      */           } else {
/*      */             
/* 1128 */             max_speed = 0.25D;
/*      */             
/* 1130 */             deltav = -0.05D;
/*      */           } 
/*      */           
/* 1133 */           newvelocity += deltav;
/* 1134 */           if (newvelocity >= 0.0D) {
/* 1135 */             if (newvelocity > max_speed) newvelocity = max_speed; 
/* 1136 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1137 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */           } else {
/* 1139 */             if (newvelocity < -max_speed) newvelocity = -max_speed; 
/* 1140 */             newvelocity = -newvelocity;
/* 1141 */             this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/* 1142 */             this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity;
/*      */           }
/*      */         
/*      */         }
/* 1146 */         else if (newvelocity >= 0.0D) {
/* 1147 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/* 1148 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 90.0F))) * newvelocity;
/*      */         } else {
/* 1150 */           this.motionX = Math.cos(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/* 1151 */           this.motionZ = Math.sin(Math.toRadians((this.rotationYaw + 270.0F))) * newvelocity * -1.0D;
/*      */         } 
/*      */ 
/*      */         
/* 1155 */         moveEntity(this.motionX, this.motionY, this.motionZ);
/* 1156 */         this.motionX *= 0.98D;
/* 1157 */         this.motionY *= 0.98D;
/* 1158 */         this.motionZ *= 0.98D;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1163 */       moveEntity(this.motionX, this.motionY, this.motionZ);
/* 1164 */       this.motionX *= 0.8D;
/* 1165 */       this.motionY *= 0.98D;
/* 1166 */       this.motionZ *= 0.8D;
/*      */ 
/*      */       
/* 1169 */       if (this.riddenByEntity != null && this.riddenByEntity.isDead)
/*      */       {
/* 1171 */         this.riddenByEntity = null;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void goThisWay(double mx, double mz) {
/* 1180 */     this.motionX = mx;
/* 1181 */     this.motionZ = mz;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/* 1189 */     if (this.riddenByEntity != null) return false; 
/* 1190 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 1195 */     super.writeEntityToNBT(par1NBTTagCompound);
/* 1196 */     par1NBTTagCompound.setInteger("AntRobotOwned", this.owned);
/*      */   }
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 1201 */     super.readEntityFromNBT(par1NBTTagCompound);
/* 1202 */     this.owned = par1NBTTagCompound.getInteger("AntRobotOwned");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getShadowSize() {
/* 1208 */     return 0.95F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/* 1216 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */     
/* 1218 */     if (var2 != null && 
/* 1219 */       var2.stackSize <= 0) {
/* 1220 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/* 1221 */       var2 = null;
/*      */     } 
/*      */ 
/*      */     
/* 1225 */     if (this.owned == 0) return true;
/*      */     
/* 1227 */     if (var2 != null && var2.getItem() == Items.iron_ingot && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0D) {
/*      */       
/* 1229 */       if (!this.worldObj.isRemote) {
/*      */         
/* 1231 */         float f = getMaxHealth() - getHealth();
/* 1232 */         if (f > 100.0F) {
/* 1233 */           f = 100.0F;
/*      */         }
/* 1235 */         if (f > 0.0F) heal(f);
/*      */       
/*      */       } 
/* 1238 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/* 1240 */         var2.stackSize--;
/* 1241 */         if (var2.stackSize <= 0)
/*      */         {
/* 1243 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/* 1246 */       return true;
/*      */     } 
/*      */     
/* 1249 */     if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != par1EntityPlayer)
/*      */     {
/* 1251 */       return true;
/*      */     }
/*      */ 
/*      */     
/* 1255 */     if (!this.worldObj.isRemote && this.riddenByEntity == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */       
/* 1257 */       par1EntityPlayer.mountEntity((Entity)this);
/*      */       
/* 1259 */       this.worldObj.playSoundAtEntity((Entity)this, "orespawn:robotspidermount", 0.45F, 1.0F);
/*      */     } 
/*      */     
/* 1262 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void feetFindSomethingToHit() {
/* 1268 */     if (OreSpawnMain.PlayNicely != 0)
/* 1269 */       return;  List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0D, 8.0D, 10.0D));
/* 1270 */     Iterator<Entity> var2 = var5.iterator();
/* 1271 */     Entity var3 = null;
/* 1272 */     EntityLivingBase var4 = null;
/*      */     
/* 1274 */     while (var2.hasNext()) {
/*      */       
/* 1276 */       var3 = var2.next();
/* 1277 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1279 */       if (feetisSuitableTarget(var4, false))
/*      */       {
/* 1281 */         feetattackEntityAsMob((Entity)var4);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean feetisSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 1289 */     if (par1EntityLiving == null)
/*      */     {
/* 1291 */       return false;
/*      */     }
/* 1293 */     if (par1EntityLiving == this)
/*      */     {
/* 1295 */       return false;
/*      */     }
/* 1297 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/* 1299 */       return false;
/*      */     }
/* 1301 */     if (par1EntityLiving instanceof AntRobot)
/*      */     {
/* 1303 */       return false;
/*      */     }
/* 1305 */     if (par1EntityLiving == this.riddenByEntity) return false; 
/* 1306 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*      */     
/* 1308 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/* 1311 */       return false;
/*      */     }
/*      */     
/* 1314 */     float d1 = (float)(par1EntityLiving.posX - this.posX);
/* 1315 */     float d2 = (float)(par1EntityLiving.posY - this.posY);
/* 1316 */     float d3 = (float)(par1EntityLiving.posZ - this.posZ);
/* 1317 */     float dd = (float)Math.sqrt((d1 * d1 + d2 * d2 + d3 * d3));
/*      */     
/* 1319 */     if (dd > 9.0F) return false; 
/* 1320 */     if (dd < 6.0F) return false;
/*      */     
/* 1322 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/* 1324 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 1325 */       if (p.capabilities.isCreativeMode == true) {
/* 1326 */         return false;
/*      */       }
/* 1328 */       return true;
/*      */     } 
/*      */ 
/*      */     
/* 1332 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean feetattackEntityAsMob(Entity par1Entity) {
/* 1337 */     boolean ret = false;
/* 1338 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/* 1340 */       double ks = 0.6D;
/* 1341 */       double inair = 0.1D;
/* 1342 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 1343 */       ret = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.AntRobot_stats.attack / 10.0F);
/* 1344 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 1345 */       if (ret) par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); 
/*      */     } 
/* 1347 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private EntityLivingBase findSomethingToAttack(float distmul, boolean dircheck) {
/* 1353 */     if (OreSpawnMain.PlayNicely != 0) return null; 
/* 1354 */     List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0D * distmul, 12.0D, 12.0D * distmul));
/* 1355 */     Iterator<Entity> var2 = var5.iterator();
/* 1356 */     Entity var3 = null;
/* 1357 */     EntityLivingBase var4 = null;
/*      */     
/* 1359 */     while (var2.hasNext()) {
/*      */       
/* 1361 */       var3 = var2.next();
/* 1362 */       var4 = (EntityLivingBase)var3;
/*      */       
/* 1364 */       if (isSuitableTarget(var4, dircheck))
/*      */       {
/* 1366 */         return var4;
/*      */       }
/*      */     } 
/* 1369 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isSuitableTarget(EntityLivingBase par1EntityLiving, boolean par2) {
/* 1376 */     if (par1EntityLiving == null)
/*      */     {
/* 1378 */       return false;
/*      */     }
/* 1380 */     if (par1EntityLiving == this)
/*      */     {
/* 1382 */       return false;
/*      */     }
/* 1384 */     if (!par1EntityLiving.isEntityAlive())
/*      */     {
/* 1386 */       return false;
/*      */     }
/* 1388 */     if (par1EntityLiving instanceof AntRobot)
/*      */     {
/* 1390 */       return false;
/*      */     }
/* 1392 */     if (par1EntityLiving == this.riddenByEntity) return false;
/*      */     
/* 1394 */     if (MyUtils.isIgnoreable(par1EntityLiving)) return false;
/*      */     
/* 1396 */     if (!getEntitySenses().canSee((Entity)par1EntityLiving))
/*      */     {
/*      */       
/* 1399 */       return false;
/*      */     }
/*      */     
/* 1402 */     if (par2) {
/*      */       
/* 1404 */       double rr = Math.atan2(par1EntityLiving.posZ - this.posZ, par1EntityLiving.posX - this.posX);
/* 1405 */       double rhdir = Math.toRadians(((this.rotationYaw + 90.0F) % 360.0F));
/*      */       
/* 1407 */       double pi = 3.1415926545D;
/*      */       
/* 1409 */       double rdd = Math.abs(rr - rhdir) % pi * 2.0D;
/* 1410 */       if (rdd > pi) rdd -= pi * 2.0D; 
/* 1411 */       rdd = Math.abs(rdd);
/*      */ 
/*      */       
/* 1414 */       if (getDistanceSqToEntity((Entity)par1EntityLiving) < 36.0D) return true; 
/* 1415 */       if (rdd > 0.75D) {
/* 1416 */         return false;
/*      */       }
/*      */     } 
/* 1419 */     if (par1EntityLiving instanceof EntityPlayer) {
/*      */       
/* 1421 */       EntityPlayer p = (EntityPlayer)par1EntityLiving;
/* 1422 */       if (p.capabilities.isCreativeMode == true) {
/* 1423 */         return false;
/*      */       }
/* 1425 */       return true;
/*      */     } 
/*      */     
/* 1428 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean attackEntityAsMob(Entity par1Entity) {
/* 1433 */     boolean ret = false;
/* 1434 */     if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
/*      */       
/* 1436 */       double ks = 0.7D;
/* 1437 */       double inair = 0.1D;
/* 1438 */       float f3 = (float)Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
/* 1439 */       ret = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), OreSpawnMain.AntRobot_stats.attack);
/* 1440 */       if (par1Entity.isDead || par1Entity instanceof EntityPlayer) inair *= 2.0D; 
/* 1441 */       if (ret) par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks); 
/*      */     } 
/* 1443 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAttacking() {
/* 1449 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAttacking(int par1) {
/* 1454 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/* 1459 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack dropItemRand(Item index, int par1) {
/* 1464 */     EntityItem var3 = null;
/* 1465 */     ItemStack is = new ItemStack(index, par1, 0);
/*      */     
/* 1467 */     var3 = new EntityItem(this.worldObj, this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.posY + 1.0D, this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
/*      */     
/* 1469 */     if (var3 != null) this.worldObj.spawnEntityInWorld((Entity)var3); 
/* 1470 */     return is;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/* 1478 */     ItemStack is = null;
/*      */ 
/*      */     
/* 1481 */     int i = 7 + this.worldObj.rand.nextInt(7);
/* 1482 */     for (int var4 = 0; var4 < i; var4++) {
/* 1483 */       int var3 = this.worldObj.rand.nextInt(12);
/* 1484 */       switch (var3) {
/*      */         case 0:
/* 1486 */           is = dropItemRand(Items.redstone, 1);
/*      */           break;
/*      */         case 1:
/* 1489 */           is = dropItemRand(Items.repeater, 1);
/*      */           break;
/*      */         case 2:
/* 1492 */           is = dropItemRand(Items.comparator, 1);
/*      */           break;
/*      */         case 3:
/* 1495 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*      */           break;
/*      */         case 4:
/* 1498 */           is = dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
/*      */           break;
/*      */         case 5:
/* 1501 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.sticky_piston), 1);
/*      */           break;
/*      */         case 6:
/* 1504 */           is = dropItemRand(Item.getItemFromBlock((Block)Blocks.piston), 1);
/*      */           break;
/*      */         case 7:
/* 1507 */           is = dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
/*      */           break;
/*      */         case 8:
/* 1510 */           is = dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
/*      */           break;
/*      */         case 9:
/* 1513 */           is = dropItemRand(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), 1);
/*      */           break;
/*      */         case 10:
/* 1516 */           is = dropItemRand(Items.iron_ingot, 1);
/*      */           break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\AntRobot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
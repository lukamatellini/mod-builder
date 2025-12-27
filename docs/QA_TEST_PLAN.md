# QA Test Plan: Voidborne Expanse

Generated: 2025-12-27T16:17:02.196Z
Minecraft Version: 1.21.1
Mod ID: voidborneexpanse

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 77 |
| Passed | 73 |
| Failed | 0 |
| Warnings | 2 |
| Skipped | 2 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `voidborneexpanse.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Ethereal Crystal | `/give @p voidborneexpanse:ethereal_crystal` | ☐ | ☐ | ☐ |
| Gravity Core | `/give @p voidborneexpanse:gravity_core` | ☐ | ☐ | ☐ |
| Void Shard | `/give @p voidborneexpanse:void_shard` | ☐ | ☐ | ☐ |
| Weightless Boots | `/give @p voidborneexpanse:weightless_boots` | ☐ | ☐ | ☐ |
| Ethereal Pickaxe | `/give @p voidborneexpanse:ethereal_pickaxe` | ☐ | ☐ | ☐ |
| Gravity Manipulator | `/give @p voidborneexpanse:gravity_manipulator` | ☐ | ☐ | ☐ |
| Void Expanse Portal Key | `/give @p voidborneexpanse:void_expanse_portal_igniter` | ☐ | ☐ | ☐ |

### Item Tests

#### Ethereal Crystal

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ethereal Crystal"
- [ ] Crafting recipe works

#### Gravity Core

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Gravity Core"
- [ ] Crafting recipe works

#### Void Shard

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Void Shard"
- [ ] Crafting recipe works

#### Weightless Boots

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Weightless Boots"
- [ ] Crafting recipe works

#### Ethereal Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ethereal Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Gravity Manipulator

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Gravity Manipulator"
- [ ] Crafting recipe works
- [ ] Right-click action works: projectile
- [ ] Cooldown applies (20 ticks)

#### Void Expanse Portal Key

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Void Expanse Portal Key"
- [ ] Crafting recipe works
- [ ] Right-click action works: custom
- [ ] Cooldown applies (40 ticks)

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Voidstone | `/give @p voidborneexpanse:voidstone` | ☐ | ☐ | ☐ |
| Ethereal Crystal Ore | `/give @p voidborneexpanse:ethereal_crystal_ore` | ☐ | ☐ | ☐ |
| Gravity Anchor Block | `/give @p voidborneexpanse:gravity_anchor_block` | ☐ | ☐ | ☐ |
| Weightless Grass Block | `/give @p voidborneexpanse:weightless_grass_block` | ☐ | ☐ | ☐ |
| Void Shroom | `/give @p voidborneexpanse:void_shroom` | ☐ | ☐ | ☐ |
| Ethereal Wood Log | `/give @p voidborneexpanse:ethereal_wood_log` | ☐ | ☐ | ☐ |

## Structures Checklist

### Void Spire
- [ ] Structure generates in world
- [ ] Use `/locate structure voidborneexpanse:void_spire` to find
- [ ] Contains expected features

### Void Expanse Obelisk
- [ ] Structure generates in world
- [ ] Use `/locate structure voidborneexpanse:void_expanse_structure` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable

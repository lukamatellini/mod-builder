# QA Test Plan: Anti-Gravity Generator

Generated: 2025-12-27T21:00:48.709Z
Minecraft Version: 1.21.1
Mod ID: antigravitygenerator

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 26 |
| Passed | 21 |
| Failed | 0 |
| Warnings | 2 |
| Skipped | 3 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `antigravitygenerator.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Gravity Core | `/give @p antigravitygenerator:gravity_core` | ☐ | ☐ | ☐ |

### Item Tests

#### Gravity Core

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Gravity Core"
- [ ] Crafting recipe works
- [ ] Right-click action works: projectile
- [ ] Cooldown applies (20 ticks)

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Anti-Gravity Generator | `/give @p antigravitygenerator:anti_gravity_generator` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
